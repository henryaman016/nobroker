package com.nobroker.service;

import com.nobroker.entity.User;
import com.nobroker.repository.UserRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Service
public class ExcelExportService {

    @Autowired
    private UserRepository userRepository;

    public void exportUsersToExcel(){
        List<User> userList = userRepository.findAll();

        try( Workbook workbook=new XSSFWorkbook()){
            Sheet sheet=workbook.createSheet("Users");

            Row headerRow =sheet.createRow(0);
            String[] columns={"ID","Name","Email","Password","Mobile","Email Verified"};
            for (int i=0;i<columns.length;i++){
                Cell cell=headerRow.createCell(i);
                cell.setCellValue(columns[i]);
            }

            int rowNum=1;
            for (User user : userList){
                Row row=sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(user.getId());
                row.createCell(1).setCellValue(user.getName());
                row.createCell(2).setCellValue(user.getEmail());
                row.createCell(3).setCellValue(user.getPassword());
                row.createCell(4).setCellValue(user.getMobile());
                row.createCell(5).setCellValue(user.isEmailVerified());

            }
            try(FileOutputStream outputStream=new FileOutputStream("G://reports//users.xlsx")) {
                workbook.write(outputStream);
            }
        }

        catch (IOException e){
            e.printStackTrace();
        }




    }

}
