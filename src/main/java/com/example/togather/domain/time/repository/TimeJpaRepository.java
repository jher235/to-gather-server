package com.example.togather.domain.time.repository;

import com.example.togather.domain.time.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeJpaRepository extends JpaRepository<Time, Long> {
}
