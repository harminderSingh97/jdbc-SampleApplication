import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Start {

	public static void main(String[] args) throws IOException {
		System.out.println("Welcome to Student Managemnt App .");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("Press 1 to ADD Student");
			System.out.println("Press 2 to DELETE Student");
			System.out.println("Press 3 to DISPLAY Student");
			System.out.println("Press 4 to EXIT Student");

			int choice = Integer.parseInt(bufferedReader.readLine());

			if (choice == 1) {
				// add student
				System.out.println("Enter Student name");
				String name = bufferedReader.readLine();
				System.out.println("Enter Student Phone");
				String phone = bufferedReader.readLine();
				System.out.println("Enter Student City");
				String city = bufferedReader.readLine();
				Student student = new Student(name, phone, city);
				System.out.println("Student :" + student);
				boolean result = StudentDao.insertStudentToDatabase(student);
				if (result) {
					System.out.println("Student inserted Successfully...");
				} else {
					System.out.println("Something went Wrong...");
				}
			} else if (choice == 2) {
				// delete Student
				System.out.println("Enter Student id to Delete:");
				int userId = Integer.parseInt(bufferedReader.readLine());
				boolean result = StudentDao.deleteStudent(userId);
				if (result) {
					System.out.println("Student deleted Successfully...");
				} else {
					System.out.println("Something went Wrong..");
				}
			} else if (choice == 3) {
				// display student
				StudentDao.showAllStudents();
			} else if (choice == 4) {
				break;
			}
		}
		System.out.println("Thanks for Using the application...");
	}
}
