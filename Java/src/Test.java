import service.Impl.StudentServiceImpl;
import service.StudentService;

public class Test {
    public static void main(String[] args) {
        StudentService studentService = new StudentServiceImpl();
        System.out.println(studentService.getAllStudentString());
    }
}
