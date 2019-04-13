package objects;

public class StudentInfo {

    private String name;
    private int id;
    private String email;
    private int cSkill;
    private int cppSkill;
    private int javaSkill;
    private char csJobEx;

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
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
