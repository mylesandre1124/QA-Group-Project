import objects.IndividualAssignment;

import java.util.HashSet;

public class GradesDB {

    private GradeImporter importer;

    public GradesDB(String fileName) {
        importer = new GradeImporter(fileName);
    }

    //Stub TODO: add logic
    public int getNumStudents() {
        return 0;
    }

    public int getNumAssignments() {
        IndividualAssignment assignment = importer.importIndividualGrades().get(1);
        int count = 0;
        if (assignment.getAssignment1() != 0) {
            count++;
        }
        if (assignment.getAssignment2() != 0) {
            count++;
        }
        if (assignment.getAssignment3() != 0) {
            count++;
        }
        return count;
    }

    //Stub TODO: add logic
    public int getNumProjects() {
        return 0;
    }

    //Stub TODO: add logic
    public HashSet<Student> getStudents() {
        return new HashSet<>();
    }

    //Stub TODO: add logic
    public Student getStudentByName(String name) {
        return new Student();
    }

    //Stub TODO: add logic
    public Student getStudentByID(String id) {
        return new Student();
    }

}
