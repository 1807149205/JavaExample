package pojo;

public class Student {

    private int id;
    private String stuName;
    private String stuSex;
    private String stuBirthday;
    private String stuDept;

    public Student(int id, String stuName, String stuSex, String stuBirthday, String stuDept) {
        this.id = id;
        this.stuName = stuName;
        this.stuSex = stuSex;
        this.stuBirthday = stuBirthday;
        this.stuDept = stuDept;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public String getStuBirthday() {
        return stuBirthday;
    }

    public void setStuBirthday(String stuBirthday) {
        this.stuBirthday = stuBirthday;
    }

    public String getStuDept() {
        return stuDept;
    }

    public void setStuDept(String stuDept) {
        this.stuDept = stuDept;
    }

    @Override
    public String toString() {
        return "{" +
                "学号=" + id +
                ", 学生姓名='" + stuName + '\'' +
                ", 学生性别='" + stuSex + '\'' +
                ", 学生出生年月='" + stuBirthday + '\'' +
                ", 学生所在系='" + stuDept + '\'' +
                '}';
    }
}
