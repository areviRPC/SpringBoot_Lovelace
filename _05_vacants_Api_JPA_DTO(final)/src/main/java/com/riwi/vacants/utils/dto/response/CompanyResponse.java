package com.riwi.vacants.utils.dto.response;

import com.riwi.vacants.entities.Vacant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyResponse {
    private String id;
    private String name;
    private  String location;
    private String contact;
    private List<VacantToCompanyResponse> vacants;
}
