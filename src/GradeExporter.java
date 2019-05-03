import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.util.ArrayList;

public class GradeExporter {

    private ExcelIO excelIO;

    public GradeExporter(String filename) {
        this.excelIO = new ExcelIO(filename);
    }

    public void setExcelSheet(int sheetIndex) {
        try {
            excelIO.setExcelSheet(sheetIndex);
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
    }

    public void appendData(ArrayList<Object> data) {
        excelIO.appendColumn(data);
    }

    public void close() {
        try {
            excelIO.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}