package com.hospital.hospitalreviewsite.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewCreateRequest {
    private Long hospitalId;
    private String userName;
    private String title;
    private String content;
}
