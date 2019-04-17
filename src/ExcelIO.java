import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

public class ExcelIO {

    private File excelFile;
    private Sheet excelSheet;


    public ExcelIO(String excelFile) {
        setExcelFile(new File(excelFile));
    }

    public ExcelIO(String excelFile, int sheetIndex) {
        setExcelFile(new File(excelFile));
        try {
            setExcelSheet(sheetIndex);
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
    }

    public ExcelIO() {
    }

    public File getExcelFile() {
        return excelFile;
    }

    public void setExcelFile(File excelFile) {
        this.excelFile = excelFile;
    }

    public void setExcelSheet(int sheetIndex) throws IOException, InvalidFormatException {
        Workbook workbook = new XSSFWorkbook(this.excelFile);
        this.excelSheet = workbook.getSheetAt(sheetIndex);
    }

    public void close() throws IOException {
        excelSheet.getWorkbook().close();
    }

    /**
     * This method imports every single line of input from an excel file as long as no empty column is between them
     * Returns an arraylist of the data
     * @return ArrayList<ArrayList>
     */
    public ArrayList<ArrayList> singleColumnInput()
    {
        Sheet datatypeSheet = excelSheet;
        Iterator<Row> iterator = datatypeSheet.iterator();
        ArrayList<ArrayList> excelList = new ArrayList();
        int columnCount = -1;
        while (iterator.hasNext())
        {
            Row currentRow = iterator.next();
            if(currentRow.getRowNum() == 0)
            {
                columnCount = currentRow.getPhysicalNumberOfCells();
            }
            Iterator<Cell> cellIterator = currentRow.iterator();
            ArrayList rowList = new ArrayList();
            ArrayList<Integer> cellNums = new ArrayList();
            while (cellIterator.hasNext())
            {
                Cell cell = cellIterator.next();
                CellType cellType = cell.getCellType();
                cellNums.add(cell.getColumnIndex());
                if(cellType.equals(CellType.STRING))
                {
                    if(cell.getStringCellValue().equals("")) {
                        rowList.add("");
                    }
                }
                switch (cellType) {
                    case NUMERIC:
                        rowList.add(cell.getNumericCellValue());
                        break;
                    case STRING:
                        rowList.add(cell.getStringCellValue());
                        break;
                }
            }
            if(rowList.size() < columnCount)
            {
                ArrayList<Integer> cellNums1 = new ArrayList();
                for (int i = 0; i < columnCount; i++) {
                    if(cellNums.indexOf(i) == -1) {
                        cellNums1.add(i);
                    }
                }
                for (int i = 0; i < cellNums1.size(); i++) {
                    if (rowList.size() < cellNums1.get(i)) {
                        rowList.add("");
                    } else {
                        rowList.add(cellNums1.get(i), "");
                    }
                }
            }
            if(!checkList(rowList)) {
                excelList.add(rowList);
            }
        }
        return excelList;
    }

    public boolean checkList(ArrayList list)
    {
        int listSize = list.size();
        int emptyCount = 0;
        for (Object o : list) {
            if (o == null) {
                emptyCount++;
            }
        }
        return emptyCount == listSize;
    }

    /**
     * This method takes a row of data and converts it into an object that is passed into it and returns the object.
     * (Cast it when it is returned)
     *
     * Pass a String ArrayList into this to denote what fields match what row number
     * @param a
     * @param fields
     * @param data
     * @return
     */
    public Object convertRowToObject(Object a, ArrayList<String> fields, ArrayList data)
    {
        try {
            for (int i = 0; i < fields.size(); i++) {
                Field field = a.getClass().getDeclaredField(fields.get(i));
                Class type = field.getType();
                ObjectConverter objectConverter = new ObjectConverter();
                //System.out.print(fields.get(i) + ": " + data.get(i) + " ");
                if (i < data.size()) {
                    objectConverter.dataConverter(data.get(i));
                }
                field.setAccessible(true);
                field.set(a, objectConverter.returnObject(type));
            }
            //System.out.println();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return a;
    }

    public int getIndex(ArrayList list)
    {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("Name"))
            {
                index = i;
            }
        }
        return index;
    }
}
