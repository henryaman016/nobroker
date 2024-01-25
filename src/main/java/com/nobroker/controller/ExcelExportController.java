package com.nobroker.controller;


import com.nobroker.service.ExcelExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/excel")
public class ExcelExportController {

    @Autowired
    private ExcelExportService excelExportService;

    //http://localhost:8080/api/excel/export

    @GetMapping("/export")
    public String exportToExcel(){
        excelExportService.exportUsersToExcel();
        return "Excel exported successfully!";
    }



}
