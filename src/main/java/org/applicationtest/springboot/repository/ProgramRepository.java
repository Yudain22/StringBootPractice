package org.applicationtest.springboot.repository;

import org.applicationtest.springboot.domain.Program;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramRepository extends JpaRepository<Program, Integer> {
}
