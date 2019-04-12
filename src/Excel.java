import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Excel {

    private File excelFile;
    private Sheet excelSheet;

    public File getExcelFile() {
        return excelFile;
    }

    public void setExcelFile(File excelFile) {
        this.excelFile = excelFile;
    }

    public void setExcelSheet(int sheetNumber) throws IOException, InvalidFormatException {
        XSSFWorkbook workbook = new XSSFWorkbook(this.excelFile);
        this.excelSheet = workbook.getSheetAt(sheetNumber);
    }

    public ArrayList<Row> getRows() {
        int rowCount = excelSheet.getPhysicalNumberOfRows();
        ArrayList<Row> excelRows = new ArrayList<>();
        for (int i = 1; i < rowCount; i++) {
            excelRows.add(excelSheet.getRow(i));
        }
        return excelRows;
    }

    public Row getRow(int rowNum) {
        ArrayList<Row> rows = getRows();
        return rows.get(rowNum);
    }

    public Object cellTypeChecker(Cell cellToCheck)
    {
        CellType cellType = cellToCheck.getCellType();
        if(cellType.equals(CellType.STRING))
        {
            return cellToCheck.getStringCellValue();
        }
        else if(cellType.equals(CellType.NUMERIC))
        {
            return cellToCheck.getNumericCellValue();
        }
        else if(cellToCheck.getStringCellValue().isEmpty())
        {
            System.out.println("empty");
            return "";
        }
        else {
            return null;
        }
    }

    public ArrayList getCellsInRow(Row row)
    {
        int cellCount = row.getPhysicalNumberOfCells();
        ArrayList cellArrayList = new ArrayList<>();
        for (int i = 0; i < cellCount; i++) {
            Object cell = cellTypeChecker(row.getCell(i));
            if(cell != null) {
                cellArrayList.add(cell);
            }
        }
        return cellArrayList;
    }

}
