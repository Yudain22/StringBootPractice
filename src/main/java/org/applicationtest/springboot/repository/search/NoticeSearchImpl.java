package org.applicationtest.springboot.repository.search;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.applicationtest.springboot.domain.Board;
import org.applicationtest.springboot.domain.Notice;
import org.applicationtest.springboot.domain.QBoard;
import org.applicationtest.springboot.domain.QNotice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class NoticeSearchImpl extends QuerydslRepositorySupport implements NoticeSearch {
    public NoticeSearchImpl() {super(Notice.class);}

    @Override
    public Page<Notice> searchAll(String keyword,Pageable pageable){
        QNotice notice = QNotice.notice;
        JPQLQuery<Notice> query = from(notice);
        BooleanBuilder booleanBuilder = new BooleanBuilder();

        if (keyword != null) {
            booleanBuilder.or(notice.title.contains(keyword));
            booleanBuilder.or(notice.content.contains(keyword));
            query.where(booleanBuilder);
        }
        query.where(notice.no.gt(0L));
        //ORDER BY bno DESC limit 0,10 : 정렬 및 리미트 SQL 추가
        this.getQuerydsl().applyPagination(pageable, query);
        //SQL 실행
        List<Notice> list = query.fetch();
        //count 관련 SQL 실행
        long count = query.fetchCount();
        return new PageImpl<>(list, pageable, count);
    }

    }

