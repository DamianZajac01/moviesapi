package com.apriproject.api.repository;

import com.apriproject.api.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DirectorRepository extends JpaRepository<Director, Long> {
    Optional<Director> getByFirstNameAndLastName(String firstName, String lastName);
}
