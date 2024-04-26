package org.applicationtest.springboot.repository.search;

import org.applicationtest.springboot.domain.Notice;
import org.applicationtest.springboot.dto.PageRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NoticeSearch {
    Page<Notice> search1(Pageable pageable);
//    Page<Notice> searchAll(String[] types,String keyword,Pageable pageable);
}
