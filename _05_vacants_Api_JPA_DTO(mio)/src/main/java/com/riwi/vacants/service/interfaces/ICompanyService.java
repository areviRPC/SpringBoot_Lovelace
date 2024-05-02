package com.riwi.vacants.service.interfaces;

import com.riwi.vacants.utils.dto.request.CompanyRequest;
import com.riwi.vacants.utils.dto.response.CompanyResponse;


// 11
public interface ICompanyService extends CrudService<CompanyRequest,CompanyResponse,String>{
    
    public CompanyResponse getById(String id); //24

}
