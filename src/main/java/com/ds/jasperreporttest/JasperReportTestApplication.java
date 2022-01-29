package com.ds.jasperreporttest;

import com.ds.jasperreporttest.Repository.EmployeeRepository;
import com.ds.jasperreporttest.bean.EmployeeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class JasperReportTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(JasperReportTestApplication.class, args);
    }

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostConstruct
    public void initUsers() {
        List<EmployeeBean> users = Stream.of(
                new EmployeeBean(0, "EmployeeName0", 50000),
                new EmployeeBean(0, "EmployeeName1",  50000),
                new EmployeeBean(0, "EmployeeName2",  150000),
                new EmployeeBean(0, "EmployeeName3",  150000),
                new EmployeeBean(0, "EmployeeName4",  250000)
        ).collect(Collectors.toList());
        employeeRepository.saveAll(users);
    }

}
