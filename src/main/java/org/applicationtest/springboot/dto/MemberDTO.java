package org.applicationtest.springboot.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    private String member_id;
    private String member_pw;
    private String name;
    private String phone;
    private String Email1;
    private String Email2;
    private String gender;
    private boolean agree ;
}
