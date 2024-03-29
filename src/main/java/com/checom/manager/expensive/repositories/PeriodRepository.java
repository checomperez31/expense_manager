package com.checom.manager.expensive.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.checom.manager.expensive.models.Period;

@Repository
public interface PeriodRepository extends JpaRepository<Period, String> {
    Optional<Period> findFirstByFinishDateIsNotNullOrderByFinishDateDesc();
}
