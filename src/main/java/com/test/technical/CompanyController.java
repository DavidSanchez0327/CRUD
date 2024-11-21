package com.test.technical;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("company")
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        Company newCompany = companyService.saveCompany(company);
        return ResponseEntity.ok(newCompany);
    }

    @GetMapping("companies")
    public ResponseEntity<List<Company>> getAllCompanies() {
        return ResponseEntity.ok(companyService.findAll().stream()
                .distinct().toList());
    }

    @GetMapping("company/{codeCompany}")
    public ResponseEntity<Company> getCompanyByCodeCompany(@PathVariable String codeCompany) {
        return ResponseEntity.ok(companyService.findByCodeCompany(codeCompany));
    }

    @PutMapping
    public ResponseEntity<Company> updateCompany(@RequestBody Company company) {

        Company updateCompany = companyService.updateCompany(company);
        return ResponseEntity.ok(updateCompany);
    }

    @DeleteMapping("company/{idCompany}")
    public ResponseEntity<String> deleteCompany(@PathVariable int idCompany) {
        int deleteCompany = companyService.deleteCompany(idCompany);
        return deleteCompany == 1 ? ResponseEntity.ok("Eliminado exitosamente") : ResponseEntity.ok("Error al eliminar");
    }
}
