import objects.StudentAttendance;
import objects.StudentInfo;
import java.util.ArrayList;


//Stub
public class Student {

    private String name;
    private String id;
    private String email;
    private int cSkill;
    private int cppSkill;
    private int javaSkill;
    private char csJobEx;

    private GradeImporter importer;

   /* public Student(String fileName) {
        importer = new GradeImporter(fileName);
    }*/

    public Student(String name, String id, String email, int cSkill, int cppSkill, int javaSkill, char csJobEx, GradeImporter importer) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.cSkill = cSkill;
        this.cppSkill = cppSkill;
        this.javaSkill = javaSkill;
        this.csJobEx = csJobEx;
        this.importer = importer;
    }

    //Stub TODO: add logic
    public int getAttendance() {
        int attendance = 0;
        ArrayList<StudentAttendance> studentAttendance = importer.importStudentAttendance();
        for (StudentAttendance s : studentAttendance) {
            if (s.getName().equalsIgnoreCase(name)) {
                attendance = s.getAttendance();
            }
        }
        return attendance;
    }


    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public int getcSkill() {return cSkill;}
    public void setcSkill(int cSkill) {this.cSkill = cSkill;}
    public int getCppSkill() {return cppSkill;}
    public void setCppSkill(int cppSkill) {this.cppSkill = cppSkill;}
    public int getJavaSkill() {return javaSkill;}
    public void setJavaSkill(int javaSkill) {this.javaSkill = javaSkill;}
    public char getCsJobEx() {return csJobEx;}
    public void setCsJobEx(char csJobEx) {this.csJobEx = csJobEx;}

}
