package com.frikasoft.eduplus_univ.repository.configuration;

import com.frikasoft.eduplus_univ.entities.db.User;
import com.frikasoft.eduplus_univ.entities.db.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
