package com.sara.rsp.repo;

import com.sara.rsp.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthResponseRepository extends JpaRepository<AuthResponse, Long> {
    // Add custom query methods if needed
}