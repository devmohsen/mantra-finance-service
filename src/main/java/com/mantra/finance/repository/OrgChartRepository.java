package com.mantra.finance.repository;

import com.mantra.finance.model.MGNR.OrgChart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrgChartRepository extends JpaRepository<OrgChart, Short> {

    Optional<List<OrgChart>> findAllByCompanyId_IdAndIsDeleted(int companyId, boolean isDeleted);

    Optional<OrgChart> findByTitle(String title);
}
