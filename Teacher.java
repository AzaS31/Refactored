public class Teacher extends User implements Comparable<Teacher> {
    private int teacherId;  

    public Teacher (int teacherId, String firstName, String secondName, String lastName) {
        super(firstName, secondName, lastName);
        this.teacherId = teacherId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId='" + teacherId +  '\'' + " " + super.toString() +
                '}';
    }

    @Override
    public int compareTo(Teacher o) {
        if (teacherId > o.getTeacherId())
            return 1;
        if (teacherId < o.getTeacherId())
            return -1;
        return 0;
    }
}
