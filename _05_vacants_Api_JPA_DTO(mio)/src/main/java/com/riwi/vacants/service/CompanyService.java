package com.riwi.vacants.service;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.vacants.entities.Company;
import com.riwi.vacants.entities.Vacant;
import com.riwi.vacants.repositories.CompanyRespository;
import com.riwi.vacants.service.interfaces.ICompanyService;
import com.riwi.vacants.utils.dto.request.CompanyRequest;
import com.riwi.vacants.utils.dto.response.CompanyResponse;
import com.riwi.vacants.utils.dto.response.VacantToCompanyResponse;

import lombok.AllArgsConstructor;

//12. 
@Service
@AllArgsConstructor
public class CompanyService implements ICompanyService {

    @Autowired
    private final CompanyRespository companyRespository;

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    // Metodo create
    @Override
    public CompanyResponse create(CompanyRequest request) { // 22
        
        Company company = this.requestToCompany(request, new Company());
    
        return this.entityToResponse(companyRespository.save(company));
    }

    @Override
    public CompanyResponse update(String id, CompanyRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    // Metodo getAll
    @Override // 13
    public Page<CompanyResponse> getAll(int page, int size) {
        if (page < 0) {
            page = 0;
        }
        PageRequest pagination = PageRequest.of(page, size);

        return this.companyRespository.findAll(pagination).map(Company -> this.entityToResponse(Company)); // 15
    }

    // Metodo findById
    @Override // 25.
    public CompanyResponse getById(String id) {
        return this.entityToResponse(this.find(id));
    }

    private Company find(String id){ // 25
        return this.companyRespository.findById(id).orElse(null);
    }



    // Metodo transforma la entidad Compañia en Company Response
    // 14
    private CompanyResponse entityToResponse(Company entity) {
        CompanyResponse response = new CompanyResponse();

        BeanUtils.copyProperties(entity, response); // 19

        response.setVacante(
                entity.getVacants().stream().map(vacant -> this.vacantToResponse(vacant)).collect(Collectors.toList()));
        return response;
    }

    
    // 20
    private VacantToCompanyResponse vacantToResponse(Vacant entity) {
        VacantToCompanyResponse response = new VacantToCompanyResponse();
        BeanUtils.copyProperties(entity, response);

        return response;
    }

    // 21
    private Company requestToCompany(CompanyRequest request, Company company){
        // Hacemos la copia de CompanyRequest
        
        BeanUtils.copyProperties(request, company);
        
        company.setVacants(new ArrayList<>());

        return company;
    }
}
