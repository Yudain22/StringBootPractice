package org.applicationtest.springboot.repository;

import org.applicationtest.springboot.domain.Board;
import org.applicationtest.springboot.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository  extends JpaRepository<Notice, Long> {
}
