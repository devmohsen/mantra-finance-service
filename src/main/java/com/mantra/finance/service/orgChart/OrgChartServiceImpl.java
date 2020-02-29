package com.mantra.finance.service.orgChart;

import com.mantra.finance.exception.ClientException;
import com.mantra.finance.exception.ServerException;
import com.mantra.finance.model.MGNR.OrgChart;
import com.mantra.finance.repository.OrgChartRepository;
import com.mantra.finance.tools.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrgChartServiceImpl implements OrgChartService {
    private final OrgChartRepository orgChartRepository;

    @Override
    public OrgChart create(OrgChart orgChart) {
        orgChart.setIsDeleted(false);
        try {
            orgChartRepository.save(orgChart);
        } catch (DataIntegrityViolationException e) {

            String property = StringUtil.getUniquePropertyFromException(e);
            throw new ClientException("error.unique.constrains.violation", property);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerException("error.internal.server");

        }
        return orgChart;
    }

    @Override
    public Optional<List<OrgChart>> getAll(int companyId) {
        return orgChartRepository.findAllByCompanyId_IdAndIsDeleted(companyId, false);
    }
}
