package com.hospital.hospitalreviewsite.controller;

import com.hospital.hospitalreviewsite.Service.ReviewService;
import com.hospital.hospitalreviewsite.domain.dto.ReviewCreateRequest;
import com.hospital.hospitalreviewsite.domain.dto.ReviewCreateResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/hospitals")
@Slf4j
public class HospitalController {

    private final ReviewService reviewService;

    public HospitalController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // "/{id}/reviews"으로 들어오면 client가 review 작성요청을 할 수 있음
    // 요청받은 내용을 Response 응답으로 변경하여 다시 client 에게 보여주는 역할
    @PostMapping("/{id}/reviews")
    public ResponseEntity<ReviewCreateResponse> add(@RequestBody ReviewCreateRequest reviewCreateRequest){
        log.info("잘넘어왔는지 : {}", reviewCreateRequest);
        return ResponseEntity.ok().body(reviewService.creatReview(reviewCreateRequest));

    }
}
