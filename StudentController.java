import java.util.ArrayList;
import java.util.List;

public class StudentController {
    UserGroup<Student> students = new UserGroup<>(new ArrayList<>());
    UserView<Student> studentView = new UserView<Student>();
    StudentGroupService studentGroupService = new StudentGroupService(students);
    
    public void createStudent (String firstName, String secondName, String lastName) {
        studentGroupService.create(firstName, secondName, lastName);
    }

    public void printSortedStudentsByFIO() {
        List<Student> sortedStudents = studentGroupService.getSortedUserGroup();
        studentView.sendOnConsole(sortedStudents);;
    }

    void printStudentList() {
        studentView.sendOnConsole(students.getUserList());
    }
}
