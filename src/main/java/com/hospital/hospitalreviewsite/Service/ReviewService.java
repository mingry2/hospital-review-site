package com.hospital.hospitalreviewsite.Service;

import com.hospital.hospitalreviewsite.domain.Hospital;
import com.hospital.hospitalreviewsite.domain.Review;
import com.hospital.hospitalreviewsite.domain.dto.ReviewCreateRequest;
import com.hospital.hospitalreviewsite.domain.dto.ReviewCreateResponse;
import com.hospital.hospitalreviewsite.repository.HospitalRepository;
import com.hospital.hospitalreviewsite.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    private final HospitalRepository hospitalRepository;
    private final ReviewRepository reviewRepository;

    public ReviewService(HospitalRepository hospitalRepository, ReviewRepository reviewRepository) {
        this.hospitalRepository = hospitalRepository;
        this.reviewRepository = reviewRepository;
    }

    // 요청받은 dto를 creatReview메서드를 사용하여 response로 반환
    public ReviewCreateResponse creatReview(ReviewCreateRequest reviewCreateRequest){
        // hospital 불러오기
        Optional<Hospital> hospitalOptional = hospitalRepository.findById(reviewCreateRequest.getHospitalId());
        // ReviewEntity 만들기
        Review review = Review.builder()
                .title(reviewCreateRequest.getTitle())
                .content(reviewCreateRequest.getContent())
                .patientName(reviewCreateRequest.getUserName())
                .hospital(hospitalOptional.get()) // 위에서 찾은 hospital의 정보를 들고옴
                .build();
        // 저장(위에서 만든 ReviewEntity로 db에 저장
        Review savedReview = reviewRepository.save(review);

        return ReviewCreateResponse.builder()
                .title(savedReview.getTitle())
                .content(savedReview.getContent())
                .userName(savedReview.getPatientName())
                .message("리뷰 등록이 성공했습니다.")
                .build();

    }
}
