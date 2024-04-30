package org.applicationtest.springboot.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.applicationtest.springboot.dto.BoardDTO;
import org.applicationtest.springboot.dto.NoticeDTO;
import org.applicationtest.springboot.dto.PageRequestDTO;
import org.applicationtest.springboot.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/ex")
@Log4j2
@RequiredArgsConstructor

public class SampleController {
    @Autowired
    private NoticeService noticeService;

    @GetMapping("/hello")
    public void hello(Model model) {
        log.info("hello");
        model.addAttribute("msg", "hello world");
    }

    @GetMapping("/ex1")
    public void ex1(Model model) {
        List<String> list = Arrays.asList("AAA", "BBB", "CCC", "DDD");
        model.addAttribute("list", list);
    }

    // Thymeleaf 인라인 처리
    class SampleDTO {
        private String p1, p2, p3;
        public String getP1() {
            return p1;
        }

        public String getP2() {
            return p2;
        }

        public String getP3() {
            return p3;
        }
    }

    @GetMapping("/ex2")
    public void ex2(Model model) {
        List<String> strList = IntStream.range(1,10)
                .mapToObj(i -> "Data" + i)
                .collect(Collectors.toList());

        model.addAttribute("list", strList);

        Map<String, String> map = new HashMap<>();
        map.put("A", "AAAA");
        map.put("B", "BBBB");
        model.addAttribute("map", map);

        SampleDTO sampleDTO = new SampleDTO();
        sampleDTO.p1 = "Value -- p1";
        sampleDTO.p2 = "Value -- p2";
        sampleDTO.p3 = "Value -- p3";

        model.addAttribute("dto", sampleDTO);
    }

    @GetMapping("/ex3")
    public void ex3(Model model) {
        model.addAttribute("arr", new String[]{"AAA", "BBB", "CCC"});
    }

    @GetMapping("/notice_list")
    public void notice_list(PageRequestDTO pageRequestDTO, Model model) {

        model.addAttribute("responseDTO",noticeService.list(pageRequestDTO));
    }

    @GetMapping("/notice_add")
    public void addGET(Model model) {

    }

    @PostMapping("/notice_add")
    public String addPOST(@Valid NoticeDTO noticeDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        log.info("notice Post register......");

        if (bindingResult.hasErrors()) {
            log.info("has errors......");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/ex/notice_add";
        }
        log.info(noticeDTO);
        Long no = noticeService.register(noticeDTO);
        redirectAttributes.addFlashAttribute("result",no);
        return "redirect:/ex/notice_list";
    }

    @GetMapping({"/notice_view","/notice_modify"})
    public void view(Long no,Model model,PageRequestDTO pageRequestDTOd) {
        model.addAttribute("notice", noticeService.readOne(no));
    }

    @PostMapping("/notice_modify")
    public String modify(PageRequestDTO pageRequestDTO,
                         @Valid NoticeDTO noticeDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        log.info("notice Modify post......"+noticeDTO);

        if (bindingResult.hasErrors()) {
            log.info("has errors......");
            String link = pageRequestDTO.getLink();
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("no", noticeDTO.getNo());
            return "redirect:/ex/notice_modify?"+link;
        }

        noticeService.modify(noticeDTO);
        redirectAttributes.addFlashAttribute("result","modified");
        redirectAttributes.addAttribute("no",noticeDTO.getNo());
        return "redirect:/ex/notice_view";
    }

    @PostMapping("/notice_remove")
    public String remove(Long no,RedirectAttributes redirectAttributes) {
        log.info("remove post..." + no);
        noticeService.remove(no);
        redirectAttributes.addFlashAttribute("result","removed");
        return "redirect:/ex/notice_list";
    }

    @GetMapping("/login")
    public void login(Model model) {

    }

    @GetMapping("/join")
    public void join(Model model) {

    }

    @GetMapping("/index")
    public void index(Model model) {

    }

    @GetMapping("/mypage")
    public void mypage(Model model) {

    }

    @GetMapping("/program")
    public void program(Model model) {

    }


}
