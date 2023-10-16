package com.frikasoft.eduplus_univ.repository.configuration;

import com.frikasoft.eduplus_univ.entities.db.Loginmanagement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginManagementRepository extends JpaRepository<Loginmanagement, Integer> {
}
