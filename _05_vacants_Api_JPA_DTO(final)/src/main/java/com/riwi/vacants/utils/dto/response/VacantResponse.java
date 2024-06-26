package com.riwi.vacants.utils.dto.response;

import com.riwi.vacants.entities.Company;
import com.riwi.vacants.utils.Enums.StateVacant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VacantResponse {
    private Long id;
    private String title;
    private String description;
    private StateVacant status;
    private CompanyToVacantResponse company;
}
