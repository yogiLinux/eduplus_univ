package com.frikasoft.eduplus_univ.repository.configuration;

import com.frikasoft.eduplus_univ.entities.db.Cours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursRepository extends JpaRepository<Cours, Integer> {
}
