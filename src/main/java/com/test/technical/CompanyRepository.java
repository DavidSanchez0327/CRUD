package com.test.technical;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public Company saveCompany(Company company) {
        String sql ="INSERT INTO company (codigo_company, name_company, description_company) VALUES ( ?, ?, ?)";
        int create = jdbcTemplate.update(sql,  company.getCodigo_company(), company.getNameCompany(), company.getDescriptionCompany());

        if (create == 1) {
            return company;
        }
        return null;
    }

    public List<Company> findAll() {
        String sql = "SELECT * FROM company";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Company.class));
    }

    public Company findByCodeCompany(String codeCompany) {
        String sql = "SELECT * FROM company WHERE codigo_company = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Company.class), codeCompany);
    }

    public Company updateCompany(Company company) {
        String sql = "UPDATE company SET name_company = ?, description_company = ? WHERE id_company = ?";
        int update = jdbcTemplate.update(sql, company.getIdCompany(), company.getNameCompany(), company.getDescriptionCompany());

        if (update == 1) {
            return company;
        }
        return null;

    }

    public int deleteCompany(int idCompany) {
        String sql = "DELETE FROM company WHERE id_company = ?";

        return jdbcTemplate.update(sql,idCompany);

    }
}
