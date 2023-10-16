package com.frikasoft.eduplus_univ.repository.configuration;

import com.frikasoft.eduplus_univ.entities.db.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartementRepository extends JpaRepository<Departement, Integer> {
}
