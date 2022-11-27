package com.hospital.hospitalreviewsite.repository;

import com.hospital.hospitalreviewsite.domain.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}
