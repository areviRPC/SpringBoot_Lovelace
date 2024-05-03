package com.riwi.vacants.services;

import com.riwi.vacants.entities.Company;
import com.riwi.vacants.entities.Vacant;
import com.riwi.vacants.repositories.CompanyRepository;
import com.riwi.vacants.repositories.VacantReposity;
import com.riwi.vacants.services.interfaces.IVacantService;
import com.riwi.vacants.utils.Enums.StateVacant;
import com.riwi.vacants.utils.dto.request.VacantRequest;
import com.riwi.vacants.utils.dto.response.CompanyToVacantResponse;
import com.riwi.vacants.utils.dto.response.VacantResponse;
import com.riwi.vacants.utils.exceptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VacantService implements IVacantService {
    @Autowired
    private  final VacantReposity vacantReposity;
    @Autowired
    private  final CompanyRepository companyRepository;
    @Override
    public void delete(Long id) {
        // busco
        Vacant vacant = this.find(id);
        // elimino 
        this.vacantReposity.delete(vacant);
    }

    @Override
    public VacantResponse create(VacantRequest request) {
        Company  company= this.companyRepository.findById(request.getCompanyId()).orElseThrow(()->new IdNotFoundException("Company"));
        Vacant vacant=this.RequestToEntity(request,new Vacant());

        vacant.setCompanies(company);
        return  this.entityToResponse(this.vacantReposity.save(vacant));
    }

    @Override // 101
    public VacantResponse update(Long aLong, VacantRequest request) {
        Vacant vacant = this.find(aLong);

        Company company = this.companyRepository.findById(request.getCompanyId()).orElseThrow(() -> new IdNotFoundException("Company"));

        vacant = this.RequestToEntity(request, vacant);

        vacant.setCompanies(company);
        if (request.getStatus() != null) {
            vacant.setStatus(request.getStatus());
        }


        return this.entityToResponse(this.vacantReposity.save(vacant));
    }

    @Override
    public Page<VacantResponse> getAll(int page, int size) {
        if (page<0)
            page=0;
        PageRequest pagination = PageRequest.of(page,size);
        return this.vacantReposity.findAll(pagination).map( pages-> this.entityToResponse(pages));
    }

    @Override
    public VacantResponse getByID(Long id) {

        return this.entityToResponse(this.find(id));
    }

    private VacantResponse entityToResponse(Vacant vacant){
        VacantResponse response = new VacantResponse();

        BeanUtils.copyProperties(vacant,response);

        CompanyToVacantResponse company = new CompanyToVacantResponse();

        BeanUtils.copyProperties(vacant.getCompanies(),company);
        response.setCompany(company);
        return response;
    }
    private Vacant RequestToEntity(VacantRequest request, Vacant vacant){
        vacant.setDescription(request.getDescription());
        vacant.setTitle(request.getTitle());
        vacant.setStatus(StateVacant.ACTIVE);
        return  vacant;
    }
    private Vacant find( Long id){
        return this.vacantReposity.findById(id).orElseThrow(()->new IdNotFoundException("Vacant"));
    }
}
