package com.framework.dataprovider;

import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class dataproviderSampleTest {

    @Test(dataProvider = "getEmployeeData",enabled = false)
    public void test1(Employee emp){
        System.out.println(emp.getName());
        System.out.println(System.getProperty("user.dir"));
        Assert.assertTrue(true);
    }

    @Test(priority = 1,dataProvider = "ExcelDataDump")
    public void excelTest(String userName,String email,String age,String height, String weight, String gender){
        System.out.println(userName);
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
    public Object[] getExcelData() throws IOException {
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

}
