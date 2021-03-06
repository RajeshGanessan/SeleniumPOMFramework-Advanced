package com.framework.utils;

import com.framework.constants.AppConstants;
import com.framework.exceptions.InvalidFilePathException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtils {

    public static List<Map<String,String>> getTestDetails(String sheetName)  {

        List<Map<String,String>> details = null;
        try(FileInputStream fs = new FileInputStream(AppConstants.getTESTCONFIGPATH())) {
            XSSFWorkbook workbook = new XSSFWorkbook(fs);
            XSSFSheet sheet = workbook.getSheet(sheetName);

            int rowCount = sheet.getLastRowNum();
            int columnCount = sheet.getRow(0).getLastCellNum();

            Map<String,String> map;
            details = new ArrayList<>();
            for(int i=1;i<=rowCount;i++){
                map = new HashMap<>();
                for(int j= 0;j<columnCount;j++){
                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    String value = sheet.getRow(i).getCell(j).getStringCellValue();
                    map.put(key,value);
                }
                details.add(map);
            }
        } catch (FileNotFoundException e ){
            throw new InvalidFilePathException("Excel file not found In location, check once");
        } catch (IOException e) {
            throw new InvalidFilePathException("NO excel file found, check once");
        }
        return details;

    }
}
