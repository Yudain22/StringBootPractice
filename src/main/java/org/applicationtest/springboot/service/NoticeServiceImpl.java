package org.applicationtest.springboot.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.applicationtest.springboot.domain.Notice;


import org.applicationtest.springboot.dto.BoardDTO;
import org.applicationtest.springboot.dto.NoticeDTO;
import org.applicationtest.springboot.dto.PageRequestDTO;
import org.applicationtest.springboot.dto.PageResponseDTO;
import org.applicationtest.springboot.repository.NoticeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor //이걸 사용해야 final 사용 가능
@Transactional
public class NoticeServiceImpl implements NoticeService {

    private final ModelMapper modelMapper;
    private final NoticeRepository noticeRepository;

    @Override
    public Long register(NoticeDTO noticeDTO) {
        Notice notice = modelMapper.map(noticeDTO, Notice.class);
        Long no = noticeRepository.save(notice).getNo();
        return no;
    }

    @Override
    public NoticeDTO readOne(Long no) {
        Optional<Notice> result = noticeRepository.findById(no);
        Notice notice = result.orElseThrow();
        NoticeDTO noticeDTO = modelMapper.map(notice, NoticeDTO.class);
        return noticeDTO;

    }

    @Override
    public void modify(NoticeDTO noticeDTO) {
        Optional<Notice> result = noticeRepository.findById(noticeDTO.getNo());

        Notice notice = result.orElseThrow();

        notice.change(noticeDTO.getTitle(), noticeDTO.getContent());
        noticeRepository.save(notice);
    }

    @Override
    public void remove(Long no) {
        noticeRepository.deleteById(no);

    }

    @Override
    public PageResponseDTO<NoticeDTO> list(PageRequestDTO pageRequestDTO) {
        String keyword = pageRequestDTO.getKeyword();
        Pageable pageable = pageRequestDTO.getPageable("no");

        Page<Notice> result = noticeRepository.searchAll(keyword,pageable);

        List<NoticeDTO> dtoList = result.getContent().stream()
                .map(notice -> modelMapper.map(notice, NoticeDTO.class))
                .collect(Collectors.toList());

        return PageResponseDTO.<NoticeDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total((int)result.getTotalElements())
                .build();
    }
    }

