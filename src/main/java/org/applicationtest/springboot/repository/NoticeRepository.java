package org.applicationtest.springboot.repository;

import org.applicationtest.springboot.domain.Board;
import org.applicationtest.springboot.domain.Notice;
import org.applicationtest.springboot.repository.search.NoticeSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NoticeRepository  extends JpaRepository<Notice, Long>, NoticeSearch
{@Query(value = "select now()",nativeQuery = true)
String getTime();
}
