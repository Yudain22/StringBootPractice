package org.applicationtest.springboot.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.applicationtest.springboot.domain.Program;
import org.applicationtest.springboot.dto.ProgramDTO;
import org.applicationtest.springboot.repository.ProgramRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class ProgramServiceImpl implements ProgramService{
    private final ProgramRepository programRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<ProgramDTO> selectAll() {
        return programRepository.findAll().stream()
                .map(program -> modelMapper.map(program, ProgramDTO.class))
                .collect(Collectors.toList());
    }
}
