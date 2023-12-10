package com.checom.manager.expensive.repositories.statsrepositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.checom.manager.expensive.models.statsmodels.GastosExtended;
import com.checom.manager.expensive.models.statsmodels.GastosExtendedId;

@Repository
public interface GastosExtendedRepository extends JpaRepository<GastosExtended, GastosExtendedId> {
    List<GastosExtended> findAllById_PeriodId(String id);
}
