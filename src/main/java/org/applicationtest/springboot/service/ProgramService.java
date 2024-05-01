package org.applicationtest.springboot.service;

import org.applicationtest.springboot.domain.Program;
import org.applicationtest.springboot.dto.ProgramDTO;

import java.util.List;

public interface ProgramService {
    List<ProgramDTO> selectAll();
}
