package com.mantra.finance.service.MGNR;

import com.mantra.finance.exception.ClientException;
import com.mantra.finance.exception.ServerException;
import com.mantra.finance.model.MGNR.NumberingMethodDetail;
import com.mantra.finance.repository.MGNR.numberingMethodDetail.NumberingMethodDetailRepository;
import com.mantra.finance.tools.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NumberingMethodDetailServiceImpl implements NumberingMethodDetailService {

    private final NumberingMethodDetailRepository numberingMethodDetailRepository;


    @Override
    public NumberingMethodDetail create(NumberingMethodDetail numberingMethodDetail) {
        try {
            numberingMethodDetailRepository.save(numberingMethodDetail);
        } catch (DataIntegrityViolationException e) {
            throw new ClientException("error.unique.constrains.violation", StringUtil.getUniquePropertyFromException(e));
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerException("error.internal.server");
        }
        return numberingMethodDetail;
    }

    @Override
    public List<NumberingMethodDetail> getAll(Integer companyId) {
        Optional<List<NumberingMethodDetail>> optionalNumberingMethodDetailList =
                numberingMethodDetailRepository.getAllByCompanyId(companyId);
        return optionalNumberingMethodDetailList.orElseGet(ArrayList::new);
    }

    @Override
    public NumberingMethodDetail getOne(Integer id) {
        Optional<NumberingMethodDetail> optionalNumberingMethodDetail = numberingMethodDetailRepository.findById(id);
        if (optionalNumberingMethodDetail.isEmpty()) {
            throw new ClientException("error.numbering.method.detail.not.found", String.valueOf(id));
        }
        return optionalNumberingMethodDetail.get();
    }

    @Override
    public NumberingMethodDetail delete(Integer id) {
        Optional<NumberingMethodDetail> optionalNumberingMethodDetail = numberingMethodDetailRepository.findById(id);
        if (optionalNumberingMethodDetail.isEmpty()) {
            throw new ClientException("error.numbering.method.detail.not.found", String.valueOf(id));
        }
        try {
            numberingMethodDetailRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerException("error.internal.server");
        }
        return optionalNumberingMethodDetail.get();
    }
}
