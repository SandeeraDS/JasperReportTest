package com.ds.jasperreporttest.Repository;

import com.ds.jasperreporttest.bean.EmployeeBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeBean,Long> {
}
