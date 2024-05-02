package com.riwi.vacants.utils.dto.response;

import com.riwi.vacants.utils.Enums.StateVacant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 3 
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VacantResponse {
    private Long id;
    private String title;
    private String description;
    private StateVacant status;
    private CompanyResponse company; // 4
}
