

package com.riwi.vacants.utils.dto.response;

import com.riwi.vacants.utils.Enums.StateVacant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // 18 
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VacantToCompanyResponse {

    private Long id;
    private String title;
    private String description;
    private StateVacant status;

    
}
