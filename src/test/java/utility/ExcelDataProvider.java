package utility;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;

public class ExcelDataProvider
{
    XSSFWorkbook wb ;
    public ExcelDataProvider ()  {

        File src = new File("./TestData/Data.xlsx");

        try {
            FileInputStream fileInputStream = new FileInputStream(src);

            wb = new XSSFWorkbook(fileInputStream);
        }
        catch (Exception e){

            System.out.println(e.getMessage());
        }

    }
    //get data usig sheetIndex
    /*public String getStringData(int sheetIndex,int row ,int column){
        return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
    }*/

    public String getStringData(String sheetName,int row ,int column){
        return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
    }

    public double getNumericData(String sheetName,int row ,int column){
        return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
    }
}
