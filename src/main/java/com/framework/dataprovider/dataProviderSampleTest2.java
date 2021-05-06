package com.framework.dataprovider;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class dataProviderSampleTest2 {


    @Test(dataProvider = "getData",enabled = false)
    public void testWithDp(String userName){
        System.out.println(userName);
    }

    @Test(description = "with EXCEL data",dataProvider = "ExcelDump",enabled = false)
    public void testWithExcel(String name,String email,String age,String height,String weight,String gender){
        System.out.println(name + email + age );
    }

    @Test(description =  "Excel with Map",dataProvider = "excelDumpWithMap")
    public void testWithExcelMap(Map<String,String> map){
        System.out.println(map.get("Name"));
    }

    @DataProvider
    public Object[] getData(){
        return new String[]{
                "rajesh", "ganessan", "Dinesh"
        };
    }

    @DataProvider(name = "ExcelDump")
    public Object[][] getExcelData() throws IOException {
        FileInputStream fs = null;
        try {
             fs = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/com/framework/tests/testData.xlsx");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheet("Login");

        int rowNum = sheet.getLastRowNum();
        int colNum = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowNum][colNum];
        for(int i=0;i<rowNum;i++){
            for(int j=0;j<colNum;j++){

                data[i][j] = sheet.getRow(i+1).getCell(j).toString();
            }
        }
        return data;
        }

        @DataProvider(name = "excelDumpWithMap")
    public Object[] getExcelDataMap() throws IOException {

            FileInputStream fs = null;
            try {
                fs = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/com/framework/tests/testData.xlsx");
            } catch (FileNotFoundException e){
                e.printStackTrace();
            }
            XSSFWorkbook workbook = new XSSFWorkbook(fs);
            XSSFSheet sheet = workbook.getSheet("Login");

            int rowNum = sheet.getLastRowNum();
            int colNum = sheet.getRow(0).getLastCellNum();
            Object[] data = new Object[rowNum];
            Map<String,String> dataMap = new HashMap<>();

            for(int i=0;i<rowNum;i++){
                dataMap = new HashMap<>();
                for(int j=0;j<colNum;j++){
                    String key = sheet.getRow(0).getCell(j).toString();
                    String value = sheet.getRow(i).getCell(j).toString();
                    dataMap.put(key,value);
                    data[i] = dataMap;
                }
            }
            return data;



        }
}
