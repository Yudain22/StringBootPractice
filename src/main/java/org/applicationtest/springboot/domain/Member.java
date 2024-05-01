package org.applicationtest.springboot.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member extends BaseEntity {
    @Id
    @Column(length = 50, nullable = false)
    private String member_id;
    @Column(length = 50, nullable = false)
    private String member_pw;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 20, nullable = false)
    private String phone;
    @Column(length = 50, nullable = false)
    private String email1;
    @Column(length = 50, nullable = false)
    private String email2;
    @Column(length = 5)
    private String gender;
    private boolean agree ;

}
