package org.applicationtest.springboot.service;

import org.applicationtest.springboot.dto.PageRequestDTO;
import org.applicationtest.springboot.dto.PageResponseDTO;
import org.applicationtest.springboot.dto.BoardDTO;

public interface BoardService {
    Long register(BoardDTO boardDTO);

    BoardDTO readOne(Long bno);

    void modify(BoardDTO boardDTO);

    void remove(Long bno);

    PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO);
}
