package com.mantra.finance.repository;


import com.mantra.finance.model.MGNR.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermission, Long> {

}
