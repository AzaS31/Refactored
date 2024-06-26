import java.util.ArrayList;
import java.util.List;

public class TeacherController {
    UserGroup<Teacher> teachers = new UserGroup<>(new ArrayList<>());
    UserView<Teacher> teacherView = new UserView<>();
    TeacherService service = new TeacherService(teachers);

    public void createTeacher(String firstName, String secondName, String lastName) {
        service.create(firstName, secondName, lastName);
    }

    public void changeTeacherName(int teacherId, String newName) {
        service.changeName(teacherId, newName);
    }

    public void printTeacherList() {
        teacherView.sendOnConsole(teachers.getUserList());
    }

    public void printSortedTeachersByFIO() {
        List<Teacher> sortedTeachers = service.getSortedUserGroupByFIO();
        teacherView.sendOnConsole(sortedTeachers);
    }

}
