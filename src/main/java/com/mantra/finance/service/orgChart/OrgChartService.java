package com.mantra.finance.service.orgChart;

import com.mantra.finance.model.MGNR.OrgChart;

import java.util.List;
import java.util.Optional;

public interface OrgChartService {

    OrgChart create(OrgChart orgChart);

    Optional<List<OrgChart>> getAll(int companyId);
}
