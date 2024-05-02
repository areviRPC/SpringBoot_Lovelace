package com.riwi.vacants.utils.dto.request;

import com.riwi.vacants.utils.Enums.StateVacant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 1.

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VacantRequest {
    private Long id;
    private String title;
    private String descripcion;
    private StateVacant status; //2
    private String companyId;
}
