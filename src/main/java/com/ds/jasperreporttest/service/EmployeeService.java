package com.ds.jasperreporttest.service;

import com.ds.jasperreporttest.Repository.EmployeeRepository;
import com.ds.jasperreporttest.bean.EmployeeBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private static final Logger logger = LogManager.getLogger(EmployeeService.class);

    @Autowired
    private  EmployeeRepository employeeRepository;

    public List<EmployeeBean> getEmployeeList() {
        logger.info("get employee List");
        return employeeRepository.findAll();
    }
}
