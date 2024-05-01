package org.applicationtest.springboot.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProgramDTO {
    private Integer no;
    private String title;
    private String text;
    private String subrtext;
    private String schedule;
    private String img;
    private LocalDate regDate;
    private LocalDate modDate;
}
