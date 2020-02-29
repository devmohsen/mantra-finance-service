package com.mantra.finance.repository.MGNR.numberingMethodDetail;

import com.mantra.finance.model.MGNR.NumberingMethod;
import com.mantra.finance.model.MGNR.NumberingMethodDetail;
import com.mantra.finance.model.MSYS.FormAttribute;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class NumberingMethodDetailRepositoryImpl implements CustomNumberingMethodDetailRepository {
    private final JdbcTemplate jdbcTemplate;


    @Override
    public Optional<List<NumberingMethodDetail>> getAllByCompanyId(Integer companyId) {
        final String sql = "SELECT nmd.ID , nmd.NUMBERINGMETHODID, nmd.FORMATTRIBUTEID" +
                " FROM MGNR.NUMBERINGMETHOD nm INNER JOIN MGNR.NUMBERINGMETHODDETAIL nmd " +
                " ON nm.ID=nmd.NUMBERINGMETHODID WHERE nm.ISACTIVE=1 AND nm.COMPANYID =" + companyId;

        return Optional.of(
                jdbcTemplate.query(sql, (rs, rowNum) -> NumberingMethodDetail.builder()
                        .id(rs.getInt(1))
                        .numberingMethodId(NumberingMethod.builder().id(rs.getInt(2)).build())
                        .formAttributeId(FormAttribute.builder().id(rs.getInt(3)).build())
                        .build()
                )
        );

    }
}
