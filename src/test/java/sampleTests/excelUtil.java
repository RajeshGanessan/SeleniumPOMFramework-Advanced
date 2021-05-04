package sampleTests;

import org.apache.poi.ss.usermodel.Sheet;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.ss.usermodel.WorkbookFactory;
public class excelUtil {

    private static String TEST_DATA_SHEET =System.getProperty("user.dir") + "/src/test/java/com/framework/tests/testData.xlsx";

    public static Object[][] getTestData(String sheetName) {

        Object data[][] = null;

        try {
            FileInputStream ip = new FileInputStream(TEST_DATA_SHEET);

           Workbook book = WorkbookFactory.create(new File(TEST_DATA_SHEET));
            Sheet sh = book.getSheet(sheetName);

            data = new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];

            for (int i = 0; i < sh.getLastRowNum(); i++) {
                for (int j = 0; j < sh.getRow(0).getLastCellNum(); j++) {
                    data[i][j] = sh.getRow(i + 1).getCell(j).toString();
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;

    }


}