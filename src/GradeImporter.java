import objects.IndividualAssignment;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class GradeImporter {

    private ExcelIO excelIO;

    public GradeImporter(String fileName) {
        this.excelIO = new ExcelIO(fileName);
    }

    public ArrayList<IndividualAssignment> importIndividualGrades() {
        ArrayList<IndividualAssignment> assignments = new ArrayList<>();
        try {
            excelIO.setExcelSheet(3);
            ArrayList<ArrayList> lists = excelIO.singleColumnInput();
            ArrayList<String> fields = new ArrayList<>(Arrays.asList("name", "assignment1", "assignment2", "assignment3"));
            for (ArrayList row: lists) {
                assignments.add((IndividualAssignment)excelIO.convertRowToObject(new IndividualAssignment(), fields, row));
            }
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
        return assignments;
    }

}
