package com.hospital.hospitalreviewsite.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // hospital은 병원 목록에 넘버가 이미 있기 때문에 없어도되지만 review는 있어야함
    private Long id;

    private String title;
    private String content;
    private String patientName;

    // hospital과 review를 매핑 해줘야 병원이름에 해당하는 리뷰를 찾을 수 있음
    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;
}
