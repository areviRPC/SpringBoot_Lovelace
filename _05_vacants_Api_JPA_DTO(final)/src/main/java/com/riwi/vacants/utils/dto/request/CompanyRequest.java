package com.riwi.vacants.utils.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder//Patron de diseño para crear una clase
@AllArgsConstructor
@NoArgsConstructor
public class CompanyRequest {
    @Size(min=0,max=40,message= "El nombre supera la cantidad de caracteres permitidos")
    @NotBlank(message="El nombre de la compañía es requerido")
    private String name;
    @NotBlank(message="El location de la compañía es requerido")
    private  String location;
    @NotBlank(message="El contacto de la compañía es requerido")
    private String contact;
}
