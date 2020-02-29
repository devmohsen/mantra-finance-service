package com.mantra.finance.repository.MGNR.subLedgerDetail;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class CustomSubLedgerDetailRepository {

    private final EntityManager entityManager;

    public void makeSubLedgerDetailDeletedBySubLedgerId(Integer subLedgerId) {
        entityManager.joinTransaction();
        Session session = (Session) entityManager.getDelegate();
        String sql = "UPDATE MGNR.SUBSIDIARYLEDGERDETAIL SET ISDELETED=1 WHERE SUBSIDIARYLEDGERID = " + subLedgerId
                ;
        session.createSQLQuery(sql).executeUpdate();
    }
}
