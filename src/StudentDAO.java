import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {

    // Add Student
    public void addStudent(Student student) {

        String query = "INSERT INTO students(name, age, course, email) VALUES (?, ?, ?, ?)";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getCourse());
            ps.setString(4, student.getEmail());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Added Successfully!");
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewStudents() {

    String query = "SELECT * FROM students";

    try {

        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        boolean found = false;

        System.out.println("\n========== STUDENT LIST ==========");

        while (rs.next()) {

            found = true;

            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String course = rs.getString("course");
            String email = rs.getString("email");

            System.out.println("ID      : " + id);
            System.out.println("Name    : " + name);
            System.out.println("Age     : " + age);
            System.out.println("Course  : " + course);
            System.out.println("Email   : " + email);
            System.out.println("-------------------------------");
        }

        if (!found) {
            System.out.println("No students found!");
        }

        rs.close();
        ps.close();
        con.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

    // Search Student
    public void searchStudent(int id) {

        String query = "SELECT * FROM students WHERE id=?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\n===== Student Found =====");
                System.out.println("ID      : " + rs.getInt("id"));
                System.out.println("Name    : " + rs.getString("name"));
                System.out.println("Age     : " + rs.getInt("age"));
                System.out.println("Course  : " + rs.getString("course"));
                System.out.println("Email   : " + rs.getString("email"));

            } else {

                System.out.println("Student Not Found!");

            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update Student
    public void updateStudent(Student student) {

        String query = "UPDATE students SET name=?, age=?, course=?, email=? WHERE id=?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getCourse());
            ps.setString(4, student.getEmail());
            ps.setInt(5, student.getId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Updated Successfully!");
            } else {
                System.out.println("Student Not Found!");
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete Student
    public void deleteStudent(int id) {

        String query = "DELETE FROM students WHERE id=?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Deleted Successfully!");
            } else {
                System.out.println("Student Not Found!");
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}