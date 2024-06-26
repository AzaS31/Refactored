import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TeacherService implements UserCreator<Teacher>, UserModifier<Teacher>, UserSorter<Teacher>{
    private UserGroup<Teacher> teachers;

    public TeacherService(UserGroup<Teacher> teachers) {
        this.teachers = teachers;
    }

    public UserGroup<Teacher> getTeacherList() {
        return teachers;
    }

    @Override
    public void create(String firstName, String secondName, String lastName) {
        int maxId = 0;
        if (!teachers.getUserList().isEmpty()) {
            maxId = teachers.getUserList().get(teachers.getUserList().size() - 1).getTeacherId() + 1;
        }
        Teacher teacher = new Teacher(maxId, firstName, secondName, lastName);
        teachers.addUser(teacher);
    }

    @Override
    public void changeName(int userId, String newName) {
        for (Teacher teacher : teachers.getUserList()) {
            if (teacher.getTeacherId() == userId) {
                teacher.setFirstName(newName);
            }
        }

    }

    @Override
    public List<Teacher> getSortedUserGroup(){
        List<Teacher> teacherList = new ArrayList<>(teachers.getUserList());
        Collections.sort(teacherList);
        return teacherList;
    }

    @Override
    public List<Teacher> getSortedUserGroupByFIO(){
        List<Teacher> teacherList = new ArrayList<>(teachers.getUserList());
        teacherList.sort(new UserComparator<Teacher>());
        return teacherList;
    }
}