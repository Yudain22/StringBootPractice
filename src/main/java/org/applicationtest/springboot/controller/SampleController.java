package org.applicationtest.springboot.controller;

import lombok.extern.log4j.Log4j2;
import org.applicationtest.springboot.dto.PageRequestDTO;
import org.applicationtest.springboot.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@Log4j2
public class SampleController {
    @Autowired
    private NoticeService noticeService;

    @GetMapping("/hello")
    public void hello(Model model) {
        log.info("hello");
        model.addAttribute("msg", "hello world");
    }

    @GetMapping("/ex/ex1")
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

    @GetMapping("/ex/ex2")
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

    @GetMapping("/ex/ex3")
    public void ex3(Model model) {
        model.addAttribute("arr", new String[]{"AAA", "BBB", "CCC"});
    }

    @GetMapping("/ex/notice_list")
    public void notice_list(PageRequestDTO pageRequestDTO, Model model) {
        model.addAttribute("noticeList",noticeService.list(pageRequestDTO));
    }

    @GetMapping("/ex/notice_add")
    public void notice_add(Model model) {
        model.addAttribute("arr", new String[]{"AAA", "BBB", "CCC"});
    }

    @GetMapping("/ex/notice_view")
    public void notice_view(Model model) {
        model.addAttribute("arr", new String[]{"AAA", "BBB", "CCC"});
    }

    @GetMapping("/ex/login")
    public void login(Model model) {

    }

    @GetMapping("/ex/join")
    public void join(Model model) {

    }

    @GetMapping("/example/index")
    public void index(Model model) {

    }

    @GetMapping("/example/mypage")
    public void mypage(Model model) {

    }

    @GetMapping("/example/program")
    public void program(Model model) {

    }


}
