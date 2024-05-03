package com.riwi.vacants.controller;

import com.riwi.vacants.services.interfaces.ICompanyService;
import com.riwi.vacants.utils.dto.request.CompanyRequest;
import com.riwi.vacants.utils.dto.response.CompanyResponse;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
@AllArgsConstructor
public class CompanyController {
    @Autowired
    private final ICompanyService companyService;
    @GetMapping
    public ResponseEntity<Page<CompanyResponse>> get(
            @RequestParam(defaultValue = "1")int page,
            @RequestParam(defaultValue = "2")int size
    ){
      return ResponseEntity.ok(this.companyService.getAll(page-1,size));
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<CompanyResponse> getById(
            @PathVariable String id
    ){
        return ResponseEntity.ok(this.companyService.getById(id));
    }
    @PostMapping
    public  ResponseEntity<CompanyResponse> insert(
            @Validated @RequestBody CompanyRequest company
            ){
        return ResponseEntity.ok(this.companyService.create(company));
    }
    @DeleteMapping(path = "/{id}")
    public  ResponseEntity<Void> delete(@PathVariable String id) {
        this.companyService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(path = "/{id}")
    public  ResponseEntity<CompanyResponse>update(
            @PathVariable String id,
            @Validated  @RequestBody CompanyRequest company
    ){

        return ResponseEntity.ok(this.companyService.update(id,company));
    }
}
