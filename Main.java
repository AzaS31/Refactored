public class Main {
    public static void main(String[] args) {
        TeacherController teacherController = new TeacherController();
        teacherController.createTeacher("Ivan", "Ivanovich", "Ivanov");
        teacherController.createTeacher("Azamat", "Azamatovich", "Azamatov");
        teacherController.createTeacher("Marat", "Maratovich", "Maratov");
        System.out.println("Teacher list:");
        teacherController.printTeacherList();
        System.out.println();
        System.out.println("Sorted By FIO List:");
        teacherController.printSortedTeachersByFIO();
        teacherController.changeTeacherName(0, "NEWNAME");
        System.out.println();
        System.out.println("Renamed:");
        teacherController.printTeacherList();
        StudentController studentController = new StudentController();
        System.out.println("Student list:");
        studentController.createStudent("AAA", "BBB", "CCC");
        studentController.createStudent("jjj", "sad", "dsd");
        studentController.printStudentList();
    }       
}