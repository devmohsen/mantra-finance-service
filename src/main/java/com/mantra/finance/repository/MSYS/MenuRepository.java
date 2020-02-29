package com.mantra.finance.repository.MSYS;

import com.mantra.finance.model.MSYS.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Short> {

    @Query(value = "SELECT DISTINCT m.CODE,m.ID,m.ENTITLE,m.FATITLE,m.ICONNAME,m.QUICKACCESS,m.TREELEVEL, m.URL " +
            " FROM MGNR.PERSON p INNER JOIN MGNR.PERSONPOST pp ON p.ID=pp.PERSONID INNER JOIN " +
            " MGNR.ORGCHARTROLE ocr on pp.ORGCHARTID = ocr.ORGCHARTID  INNER JOIN MGNR.MENUROLE mr on " +
            " ocr.ROLEID=mr.ROLEID RIGHT JOIN MSYS.MENU m ON mr.MENUID=m.ID where p.ID = :personId " +
            " AND p.ISDELETED=0 and p.COMPANYID = :companyId AND pp.ISDELETED =0 AND ocr.ISDELETED=0", nativeQuery = true)
    Optional<List<Menu>> getPersonMenu(@Param("personId") Integer personId, @Param("companyId") Integer companyId);
}
