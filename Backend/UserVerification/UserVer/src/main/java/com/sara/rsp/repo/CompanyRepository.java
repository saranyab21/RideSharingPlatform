package com.sara.rsp.repo;

import com.sara.rsp.entity.Company;
import com.sara.rsp.repo.interfaces.*;
import java.util.List;

//import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CompanyRepository implements ICompanyRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Company> getAllCompanies() {
        return entityManager.createQuery("SELECT c FROM Company c", Company.class)
                .getResultList();
    }
}
