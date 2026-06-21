import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {

            System.out.println("\n======================================");
            System.out.println("   STUDENT REGISTRATION SYSTEM");
            System.out.println("======================================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    Student student = new Student();

                    System.out.print("Enter Name: ");
                    student.setName(sc.nextLine());

                    System.out.print("Enter Age: ");
                    student.setAge(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Enter Course: ");
                    student.setCourse(sc.nextLine());

                    System.out.print("Enter Email: ");
                    student.setEmail(sc.nextLine());

                    dao.addStudent(student);
                    break;

                case 2:

                    dao.viewStudents();
                    break;

                case 3:

                    System.out.print("Enter Student ID: ");
                    int searchId = sc.nextInt();

                    dao.searchStudent(searchId);
                    break;

                case 4:

                    Student updateStudent = new Student();

                    System.out.print("Enter Student ID: ");
                    updateStudent.setId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    updateStudent.setName(sc.nextLine());

                    System.out.print("Enter New Age: ");
                    updateStudent.setAge(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Enter New Course: ");
                    updateStudent.setCourse(sc.nextLine());

                    System.out.print("Enter New Email: ");
                    updateStudent.setEmail(sc.nextLine());

                    dao.updateStudent(updateStudent);
                    break;

                case 5:

                    System.out.print("Enter Student ID: ");
                    int deleteId = sc.nextInt();

                    dao.deleteStudent(deleteId);
                    break;

                case 6:

                    System.out.println("Thank you for using the Student Registration System!");
                    sc.close();
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice! Try Again.");
            }
        }
    }
}