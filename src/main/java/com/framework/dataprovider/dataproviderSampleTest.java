package com.framework.dataprovider;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class dataproviderSampleTest {

    @Test(dataProvider = "getEmployeeData",enabled = false)
    public void test1(Employee emp){
        System.out.println(emp.getName());
        System.out.println(System.getProperty("user.dir"));
        Assert.assertTrue(true);
    }

    @Test(priority = 1,dataProvider = "ExcelDataDump", enabled = false)
    public void excelTest(String userName,String email,String age,String height, String weight, String gender){
        System.out.println(userName);
    }

    @Test(priority = 2, dataProvider = "ExcelDataWithMap")
    public void excelWithMap(Map<String,String> map ){
        System.out.println(map.get("Name"));
        System.out.println(map.get("Email"));
    }

    @DataProvider
    public Object[] getData(){
        return new String[]{
                "test1", "test2"
        };
    }

    @DataProvider
    public Object[] getEmployeeData(){
        return new Employee[]{
               new Employee("Rajesh","one"),
               new Employee("dinesh","two"),
                new Employee("ganessan","three")
        };
    }

    @DataProvider(name = "ExcelDataDump")
    public Object[][] getExcelData() throws IOException {
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/com/framework/tests/testData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("Login");

        int rowNum  = sheet.getLastRowNum();
        int colNum  = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowNum][colNum];
        for(int i=1;i<=rowNum;i++){
            for(int j=0;j<colNum;j++){
                 data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
            }
        }

        return data;
    }

    @DataProvider(name = "ExcelDataWithMap")
    public Object[] excelWithMap() throws IOException {
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/com/framework/tests/testData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("Login");

        int rowNum  = sheet.getLastRowNum();
        int colNum  = sheet.getRow(0).getLastCellNum();

        Object[] data = new Object[rowNum];
        Map<String,String> dataMap = new HashMap<>();

        for(int i=1;i<=rowNum;i++){
            dataMap = new HashMap<>();
            for(int j=0;j<colNum;j++){

                String key = sheet.getRow(0).getCell(j).getStringCellValue();
                String value = sheet.getRow(i).getCell(j).getStringCellValue();
                dataMap.put(key,value);
                data[i-1] = dataMap;

            }
        }
        return data;
    }

}
