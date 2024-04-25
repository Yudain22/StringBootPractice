package org.applicationtest.springboot.service;

import org.applicationtest.springboot.dto.NoticeDTO;
import org.applicationtest.springboot.dto.PageRequestDTO;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface NoticeService {
    List<NoticeDTO> getNoticeList(PageRequestDTO pageRequestDTO);

}
