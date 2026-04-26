package com.belkiz.cruddemo;

import com.belkiz.cruddemo.dao.StudentDAO;
import com.belkiz.cruddemo.dao.StudentDAOImpl;
import com.belkiz.cruddemo.entity.Student;
import jakarta.persistence.TypedQuery;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	private final StudentDAOImpl studentDAOImpl;

	public CruddemoApplication(StudentDAOImpl studentDAOImpl) {
		this.studentDAOImpl = studentDAOImpl;
	}

	public static void main(String[] args) {SpringApplication.run(CruddemoApplication.class, args);}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return args -> {
			createStudent(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println(numRowsDeleted + " students are deleted successfully!");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		studentDAO.delete(2);
		System.out.println("deleted successfully");
	}

	private void updateStudent(StudentDAO studentDAO){
		Student student = studentDAO.findById(1);
		student.setFirstName("Halil");
		studentDAO.updateStudent(student);
		System.out.println(student);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> studentList = studentDAO.findByLastName("Karanina");
		for(Student student: studentList){
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> allStudents = studentDAO.findAll();
		for(Student student: allStudents){
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		Student student = new Student("Anna", "Karanina", "karaninaanna@gmail.com");
		studentDAO.save(student);
		int id = student.getId();
		studentDAO.findById(id);
		System.out.println(student);
	}

	private void createStudent(StudentDAO studentDAO) {
		Student student = new Student("Berk", "Özer", "ozerberk@gmail.com");
		studentDAO.save(student);
	}


}
