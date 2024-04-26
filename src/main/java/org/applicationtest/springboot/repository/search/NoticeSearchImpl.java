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
    public NoticeSearchImpl() {
        super(Notice.class);}
    @Override
    public Page<Notice>search1(Pageable pageable){
        QNotice qNotice = QNotice.notice;
        JPQLQuery<Notice> query = from(qNotice);

        query.where(qNotice.title.contains("1"));

        this.getQuerydsl().applyPagination(pageable,query);
        List<Notice> notiecs = query.fetch();
        long conut = query.fetchCount();
        return null;
    }

//    @Override
//    public Page<Notice> searchAll(String[] types,String keyword,Pageable pageable){
//        QNotice qNotice = QNotice.notice;
//        JPQLQuery<Notice> query = from(qNotice);
//        if((types != null && types.length > 0) && keyword != null) {
//            BooleanBuilder booleanBuilder = new BooleanBuilder();
//            for(String type : types) {
//                switch(type) {
//                    //OR title LIKE '%keyword%' : SQL 작성
//                    case "t":
//                        booleanBuilder.or(qNotice.title.contains(keyword));
//                        break;
//                    //OR content LIKE '%keyword%' : SQL 작성
//                    case "c":
//                        booleanBuilder.or(qNotice.content.contains(keyword));
//                        break;
//                }
//            }
//            //실행할 쿼리문에 types, keyword 조건절 추가
//            query.where(booleanBuilder);
//        }
//        //and bno > 0 : WHERE 쿼리 추가
//        query.where(qNotice.no.gt(0L));
//        //ORDER BY bno DESC limit 0,10 : 정렬 및 리미트 SQL 추가
//        this.getQuerydsl().applyPagination(pageable, query);
//        //SQL 실행
//        List<Notice> list = query.fetch();
//        //count 관련 SQL 실행
//        long count = query.fetchCount();
//        return new PageImpl<>(list, pageable, count);
//    }

    }

