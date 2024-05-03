package com.riwi.vacants.controller;

import com.riwi.vacants.services.interfaces.IVacantService;
import com.riwi.vacants.utils.dto.errors.ErrorResponse;
import com.riwi.vacants.utils.dto.request.VacantRequest;
import com.riwi.vacants.utils.dto.response.VacantResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/vacants")
@AllArgsConstructor
@Tag (name = "Vacantes")
public class VacantController {
    @Autowired
    private final IVacantService vacantService;


    @Operation(
        summary = "Lista todas las vacantes con paginacion",
        description = "Denes enviar la pagina y el tamaño de la pagina para recibir toda las vacantes correspondientes"
    )
    @GetMapping
    public ResponseEntity<Page<VacantResponse>>  getAll(@RequestParam(defaultValue = "1") int page,
                                                        @RequestParam(defaultValue = "5")int size){
        return ResponseEntity.ok(this.vacantService.getAll(page-1,size));
    }
    
    @ApiResponse(
        responseCode = "400",
        description = "cuando el id no es valio o no existe",
        content = {
            @Content(
                mediaType = "application/JSON",
                schema = @Schema( implementation = ErrorResponse.class)
            )
        }
    )

    @Operation(
        summary = "Lista una vacante por ID",
        description = "Denes enviar el id de la vacante a buscar"
    )
    @GetMapping(path = "/{id}")
    public ResponseEntity<VacantResponse> get(@PathVariable long id){
        return ResponseEntity.ok(this.vacantService.getByID(id));
    }


    @Operation(
        summary = "Crea una vacante",
        description = "Denes enviar los atributos de la vacante para crearla"
    )
    @PostMapping
    public ResponseEntity<VacantResponse> insert ( @Validated @RequestBody VacantRequest vacant){

        return  ResponseEntity.ok(this.vacantService.create(vacant));
    }

    @Operation(
        summary = "Elimina una vacante por ID",
        description = "Debes enviar el id de la vacante a borrar"
    )
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id){

        // crrear el Map
        Map <String, String> response = new HashMap<>();

        // agregar mensaje
        response.put("message","se elimino la vacante");

        this.vacantService.delete(id);
        return ResponseEntity.ok(response);
    }

    // 101
    @Operation(
        summary = "actualiza una vacante por ID",
        description = "Debes enviar el id de la vacante a actualiza y los atributos"
    )
    @PutMapping(path = "/{id}")
    public ResponseEntity<VacantResponse> update(
        @PathVariable Long id,
        @Validated @RequestBody VacantRequest vacant
    ){
        return ResponseEntity.ok(this.vacantService.update(id, vacant))  ;
    }
}
    