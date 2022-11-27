package com.hospital.hospitalreviewsite.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Hospital {
    @Id
    private Long id;

    private String hospitalName; // 병원 이름
    private String roadNameAddress; // 병원 주소

    // 병원정보 조회 시 리뷰도 함께 나오려면 양방향 매핑이 필요
    @OneToMany(mappedBy = "hospital", fetch = FetchType.LAZY)
    private List<Review> reviews;
}
