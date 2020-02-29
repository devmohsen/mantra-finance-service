package com.mantra.finance.controller.MGNR.dto;

import com.mantra.finance.model.MGNR.Company;
import com.mantra.finance.model.MGNR.OrgChart;
import com.mantra.finance.model.MGNR.Zone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;


@RequiredArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class OrgChartPostDTO {

    private Short id;

    private String title;

    private String code;

    private String path;

    private OrgChart parentId;

    private Zone zoneId;
    private Boolean isDeleted = false;

    private Company companyId;

    public OrgChart toModel() {
        OrgChart orgChart = OrgChart.builder().build();
        BeanUtils.copyProperties(this, orgChart);
        return orgChart;
    }

    public OrgChartPostDTO fromModel(OrgChart orgChart) {
        OrgChartPostDTO dto = OrgChartPostDTO.builder().build();
        BeanUtils.copyProperties(orgChart, dto);
        return dto;
    }
}
