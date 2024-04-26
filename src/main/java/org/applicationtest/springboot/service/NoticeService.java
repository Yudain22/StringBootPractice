package org.applicationtest.springboot.service;

import org.applicationtest.springboot.dto.NoticeDTO;
import org.applicationtest.springboot.dto.PageRequestDTO;
import org.applicationtest.springboot.dto.PageResponseDTO;

import java.util.List;

public interface NoticeService {
    Long register(NoticeDTO noticeDTO);

    NoticeDTO readOne(Long no);

    void modify(NoticeDTO noticeDTO);

    void remove(Long no);

    PageResponseDTO<NoticeDTO> list(PageRequestDTO pageRequestDTO);

}
