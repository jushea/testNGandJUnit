package ex12;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {

    private HSSFSheet excelWSheet;
    private HSSFWorkbook excelWBook;
    private HSSFCell cell;

    public void setExcelFile(String path, String sheetName) {
        try {
            FileInputStream excelFile = new FileInputStream(path);

            excelWBook = new HSSFWorkbook(excelFile);
            excelWSheet = excelWBook.getSheet(sheetName);
        } catch (Exception e) {
            System.out.println("Exception " + e.getMessage());
        }
    }

    public List getRowContains(String testCaseName, int colNum) {
        List list = new ArrayList ();
        int rowCount = getRowUsed();

        for (int i = 0; i <= rowCount; i++) {
            String cellData = getCellData(i, colNum);
            if (cellData.equalsIgnoreCase(testCaseName)) {
                list.add(i);
            }
        }
        return list;
    }

    public int getRowUsed() {
        return excelWSheet.getLastRowNum();
    }

    public String getCellData(int rowNum, int colNum) {
        try {
            cell = excelWSheet.getRow(rowNum).getCell(colNum);
            return cell.getStringCellValue();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public List[] getRowData(int rowNo) {
        List[] arr = new List[1];
        List list = new ArrayList();
        int startCol = 1;

        int totalCols = excelWSheet.getRow(rowNo).getPhysicalNumberOfCells();

        for(int i = startCol; i < totalCols; i++) {
            String cellData = getCellData(rowNo, i);
            list.add(cellData);
        }
        arr[0] = list;
        return arr;
    }

    public Object[][] getTableArray(List<Integer> rowsNo) {
        Object[][] tabArray = new Object[rowsNo.size()][];
        for(int i = 0; i < rowsNo.size(); i++) {
            tabArray[i] = getRowData(rowsNo.get(i));
        }
        return tabArray;
    }

}
