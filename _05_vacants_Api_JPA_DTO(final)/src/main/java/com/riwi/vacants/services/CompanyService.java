package com.riwi.vacants.services;

import com.riwi.vacants.entities.Company;
import com.riwi.vacants.entities.Vacant;
import com.riwi.vacants.repositories.CompanyRepository;
import com.riwi.vacants.services.interfaces.ICompanyService;
import com.riwi.vacants.utils.dto.request.CompanyRequest;
import com.riwi.vacants.utils.dto.response.CompanyResponse;
import com.riwi.vacants.utils.dto.response.VacantToCompanyResponse;
import com.riwi.vacants.utils.exceptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CompanyService implements ICompanyService {
     @Autowired
    private final CompanyRepository companyRepository;
    @Override
    public void delete(String s) {
        Company company = this.find(s);
        this.companyRepository.delete(company);
    }

    @Override
    public CompanyResponse create(CompanyRequest request) {
       Company company = this.requestToCompany(request,new Company());
       return  this.entityResponse(this.companyRepository.save(company));
    }

    @Override
    public CompanyResponse update(String s, CompanyRequest request) {
        Company company= this.find(s);
        Company companyUpdate = this.requestToCompany(request,company);
        return this.entityResponse(this.companyRepository.save(companyUpdate));
    }

    @Override
    public Page<CompanyResponse> getAll(int page, int size) {
        if (page<0)
            page=0;
        PageRequest pagination = PageRequest.of(page,size);
//        return this.companyRepository.findAll(pagination).map(company -> this.entityResponse(company));
        return this.companyRepository.findAll(pagination).map(this::entityResponse);
    }
    @Override
    public CompanyResponse getById(String id) {
        return this.entityResponse(this.find(id));
    }
    private  Company find(String id){
        return this.companyRepository.findById(id).orElseThrow(()->new IdNotFoundException("Company"));
    }
    private CompanyResponse entityResponse(Company entity){
        CompanyResponse response = new CompanyResponse();
//        response.setId(entity.getId());
//        response.setName(entity.getName());
//        response.setLocation(entity.getLocation());
//        response.setVacants(entity.getVacants());
//        response.setContact(entity.getContact());
        BeanUtils.copyProperties(entity,response);
        response.setVacants(entity.getVacants().stream().map(vacant ->this.vacantToResponse(vacant)).collect(Collectors.toList()));

        return response;
    }
    private VacantToCompanyResponse vacantToResponse(Vacant entity){
        VacantToCompanyResponse response = new VacantToCompanyResponse();
        BeanUtils.copyProperties(entity,response);
        return response;
    }private Company requestToCompany(CompanyRequest request,Company company){
        // hacemos la copia
        BeanUtils.copyProperties(request,company);
        company.setVacants(new ArrayList<>());
        return company;
    }


}
