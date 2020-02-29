package com.mantra.finance.repository;

import com.mantra.finance.model.MGNR.OrgChart;
import com.mantra.finance.model.MGNR.OrgChartRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrgChartRoleRepository extends JpaRepository<OrgChartRole, Short> {
//    Optional<Collection<OrgChartRole>> findByOrgChartId(OrgChart orgChartId);

    List<OrgChartRole> findByOrgChartId(OrgChart orgChart);
}
