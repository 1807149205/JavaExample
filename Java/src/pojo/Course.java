package pojo;

public class Course {

    private int stu_id;
    private String math;
    private String chinese;
    private String english;

    public Course(int stu_id, String math, String chinese, String english) {
        this.stu_id = stu_id;
        this.math = math;
        this.chinese = chinese;
        this.english = english;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public String getMath() {
        return math;
    }

    public void setMath(String math) {
        this.math = math;
    }

    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }
}
