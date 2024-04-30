package org.applicationtest.springboot.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.applicationtest.springboot.domain.Member;
import org.applicationtest.springboot.dto.MemberDTO;
import org.applicationtest.springboot.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
public class MemverServiceImpl implements MemberService{
    private final ModelMapper modelMapper;
    private final MemberRepository memberRepository;

    @Override
    public void register(MemberDTO memberDTO){
        memberRepository.save(modelMapper.map(memberDTO, Member.class));
    }

    @Override
    public MemberDTO readOne(String memberId){
        return modelMapper.map(memberRepository.findById(memberId),MemberDTO.class);
    }
}
