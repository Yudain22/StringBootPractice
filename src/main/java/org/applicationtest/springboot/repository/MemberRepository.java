package org.applicationtest.springboot.repository;

import org.applicationtest.springboot.domain.Board;
import org.applicationtest.springboot.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
}
