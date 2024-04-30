package org.applicationtest.springboot.service;

import org.applicationtest.springboot.dto.BoardDTO;
import org.applicationtest.springboot.dto.MemberDTO;

public interface MemberService {
    void register(MemberDTO memberDTO);
    MemberDTO readOne(String memberId);
}
