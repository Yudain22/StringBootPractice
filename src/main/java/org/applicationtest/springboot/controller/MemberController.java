package org.applicationtest.springboot.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.applicationtest.springboot.domain.Member;
import org.applicationtest.springboot.dto.MemberDTO;
import org.applicationtest.springboot.repository.MemberRepository;
import org.applicationtest.springboot.service.MemberService;
import org.applicationtest.springboot.service.MemverServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/member")
@Log4j2
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;
    private final MemverServiceImpl memverServiceImpl;

    @GetMapping("/join")
    public String join(MemberDTO memberDTO) {
        return "/ex/join";
    }

    @PostMapping("/join")
    public String addJoin(MemberDTO memberDTO) {
        memberDTO.setEmail1(memberDTO.getMember_id());
        memberService.register(memberDTO);
        return "redirect:/ex/index";
    }

    @PostMapping("/login")
    public String postLogin(HttpServletRequest req, String member_id, String member_pw) {
        MemberDTO loginInfo = memberService.login(member_id, member_pw);
        HttpSession session = req.getSession();
        session.setAttribute("loginInfo", loginInfo);
        return "redirect:/ex/index";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "/ex/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest req, HttpServletResponse resp) {
        //session 을 변수로 설정했기 때문에 중복 사용 가능
        HttpSession session = req.getSession();
        session.removeAttribute("loginInfo");
        session.invalidate();
        //session을 만들지 않고  getSEssion의 결과물에 바로 메서드를 실행하는 방식, 중복 사용 불가능
//        req.getSession().removeAttribute("loginInfo");
//        req.getSession().invalidate();
        return "redirect:/ex/index";
    }
}