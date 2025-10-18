package com.student;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import com.student.*;
public class StudentTest {

	public static void main(String[] args) {
		
		// comparator for decreasing order of attendance
		List<Student> studentList = new ArrayList<>();
		try {
			// create 10 student objects
			studentList.add(new Student(1, "Vaibhav", "Java", 95, 88));
            studentList.add(new Student(2, "Neha", "Python", 64, 90));
            studentList.add(new Student(3, "Jiya", "C#", 75, 80));
            studentList.add(new Student(4, "Kunal", "Java", 78, 92));
            studentList.add(new Student(5, "Ghanshyam", "C++", 82, 70));
            studentList.add(new Student(6, "Prajwal", "Data Science", 90, 96));
            studentList.add(new Student(7, "Rajesh", "AI", 88, 91));
            studentList.add(new Student(8, "Ritu", "Web Dev", 88, 85));
            studentList.add(new Student(9, "Karan", "React", 60, 75));
            studentList.add(new Student(10, "Deepak", "ML", 55, 80));
            
		} catch(LowAttendanceException e) {
			System.out.println("Exception"+e.getMessage());
		}
		
		// sort list in decreasing order of attendance
		studentList.sort((s1, s2) -> Double.compare(s2.getAttendancePercentage(), s1.getAttendancePercentage()));
		
		// Serialize Student objects to file
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat"))){
			oos.writeObject(studentList);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		// display students in decreasing order of attendance
		System.out.println("\n Students in decreasing order of attendance : ");
		for(Student s : studentList) {
			System.out.println(s);
		}
	}

}
