package com.frikasoft.eduplus_univ.repository.configuration;

import com.frikasoft.eduplus_univ.entities.db.Etablissement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtablissementRepository extends JpaRepository<Etablissement, Integer> {
}
