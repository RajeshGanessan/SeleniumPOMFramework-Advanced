package sampleTests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class test {


    @Test(dataProvider = "ExcelDataDump")
    public void getDetails(String FirstName,String LastName,String Email,String Phone,
                           String Password,String ConfirmPassword,String teamSize){

        System.out.println(FirstName + " " +LastName + " " + Email + " " + Phone + " " + Password +" " + ConfirmPassword
        + " " + teamSize);
    }

    @DataProvider(name = "ExcelDataDump")
    public Object[][] getExcelData() throws IOException {
        FileInputStream file = new FileInputStream("/Users/rajeshlv/Downloads/UrbanusTestdata.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("Sheet2");

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
