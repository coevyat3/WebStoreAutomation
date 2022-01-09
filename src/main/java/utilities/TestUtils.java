package utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.FileInputStream;
import java.io.IOException;

public class TestUtils {

    public static String path1 = "C:\\Users\\coevy\\IdeaProjects\\WebStoreAuto\\src\\main\\resources\\LoginData.xlsx";
    public static String path2="C:\\Users\\coevy\\IdeaProjects\\WebStoreAuto\\src\\main\\resources\\a1.xlsx";
    static DataFormatter formatter= new DataFormatter();


    public static Object [][] getData(String login) throws IOException
    {
        FileInputStream fis= new FileInputStream("C:\\Users\\coevy\\IdeaProjects\\WebStoreAuto\\src\\main\\resources\\LoginData.xlsx");
        XSSFWorkbook wb= new XSSFWorkbook(fis);
        XSSFSheet sheet=wb.getSheetAt(0);
        int rowCount=sheet.getPhysicalNumberOfRows();
        XSSFRow row=sheet.getRow(0);
        int colCount=row.getLastCellNum();
        Object data[][]= new Object[rowCount-1][colCount];
        for(int i=0;i<rowCount-1;i++){
            for(int j=0;j<colCount;j++){
                XSSFCell cell=row.getCell(j);
                data[i][j]=formatter.formatCellValue(cell);
            }
        }

        return data;
    }
    public static String[][] getData1(String login) throws IOException {

        XLUtility xlUtility= new XLUtility(path2);
        int rows=xlUtility.getRowCount("sheet1");
        int cols=xlUtility.getCellCount("sheet1",1);
        String data1[][]= new String[rows][cols];
        for(int i=1;i<rows;i++){
            for(int j=0;j<cols;j++){
                data1[i-1][j]=xlUtility.getCellData("sheet1",i,j);
            }
        }

return data1;

    }

}