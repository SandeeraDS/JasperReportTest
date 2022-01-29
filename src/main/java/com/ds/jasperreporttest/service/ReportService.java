package com.ds.jasperreporttest.service;


import com.ds.jasperreporttest.Repository.EmployeeRepository;
import com.ds.jasperreporttest.bean.EmployeeBean;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {
    private static final Logger logger = LogManager.getLogger(EmployeeService.class);
    private static final String FILE_PATH = "E:\\2022\\Practicles\\JasperReportTest\\Reports\\";
    @Autowired
    private EmployeeRepository employeeRepository;

    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        List<EmployeeBean> employees = employeeRepository.findAll();
        logger.info("employee list size :{} ",employees.size());
        File file = ResourceUtils.getFile("classpath:templates/EmployeeList.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("createdBy", "Sandeera");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, dataMap, dataSource);
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, FILE_PATH + "employeeList.html");
        } else if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, FILE_PATH + "employeeList.pdf");
        }
        return "Report generated at "+FILE_PATH;
    }
}
