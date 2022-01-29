package com.ds.jasperreporttest.controller;

import com.ds.jasperreporttest.bean.EmployeeBean;
import com.ds.jasperreporttest.service.EmployeeService;
import com.ds.jasperreporttest.service.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
public class EmployeeController {

    private static final Logger logger = LogManager.getLogger(EmployeeController.class);
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ReportService reportService;

    @GetMapping("/getEmployees")
    public List<EmployeeBean> getEmployees(){
        logger.info("get employee List");
        return employeeService.getEmployeeList();
    }

    @GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws JRException, FileNotFoundException {
        logger.info("generate report by format :{}", format);
        return reportService.exportReport(format);
    }

}
