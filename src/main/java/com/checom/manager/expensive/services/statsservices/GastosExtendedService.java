package com.checom.manager.expensive.services.statsservices;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.checom.manager.expensive.models.statsmodels.GastosExtended;
import com.checom.manager.expensive.repositories.statsrepositories.GastosExtendedRepository;

@Service
public class GastosExtendedService {
    private final GastosExtendedRepository repository;

    public GastosExtendedService(GastosExtendedRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly=true)
    public List<GastosExtended> findTypesByPeriod(String id) {
        return this.repository.findAllById_PeriodId( id );
    }
}
