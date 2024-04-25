package org.applicationtest.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.applicationtest.springboot.domain.Board;
import org.applicationtest.springboot.repository.search.BoardSearch;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardSearch {
    @Query(value = "select now()",nativeQuery = true)
    String getTime();
}
