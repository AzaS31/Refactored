import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentGroupService implements UserCreator<Student>, UserSorter<Student> {
    private UserGroup<Student> studentGroup;

    public StudentGroupService(UserGroup<Student> studentGroup) {
        this.studentGroup = studentGroup;
    }

    public UserGroup<Student> getStudentGroup() {
        return studentGroup;
    }

    @Override
    public void create(String firstName, String secondName, String lastName) {
        int maxId = 0;
        if(!studentGroup.getUserList().isEmpty()) {
            maxId = studentGroup.getUserList().get(studentGroup.getUserList().size() - 1).getStudentId() + 1;
        }
        Student student = new Student(maxId, firstName, secondName, lastName);
        studentGroup.addUser(student);
    }

    @Override
    public List<Student> getSortedUserGroup(){
        List<Student> studentList = new ArrayList<>(studentGroup.getUserList());
        Collections.sort(studentList);
        return studentList;
    }

    @Override
    public List<Student> getSortedUserGroupByFIO(){
        List<Student> studentList = new ArrayList<>(studentGroup.getUserList());
        studentList.sort(new UserComparator<Student>());
        return studentList;
    }
}