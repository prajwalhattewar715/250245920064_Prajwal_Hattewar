package com.student;

import java.io.*;
import java.util.*;


public class Student implements Serializable {
	private int rollno;
	private String sname;
	private String course;
	private double attendance_percentage;
	private double score;
	private String grade;
	
	
	//Default Constructor
	public Student() {
		super();
	}
	
	
	//Parameterized Constructor
	public Student(int rollno, String sname, String course, double attendance_percentage, double score) throws LowAttendanceException {
		super();
		this.rollno = rollno;
		this.sname = sname;
		this.course = course;
		this.attendance_percentage = attendance_percentage;
		this.score = score;
		
		
		// check attendance
		if(attendance_percentage < 60 ) {
			throw new LowAttendanceException("Attendance is below 60%  of student "+sname);
		}
		
		// calculate grade
		calculateGrade();
		
	}
	
	public void calculateGrade() {
		if(score >= 90) {
			grade="A+";
		}
		else if(score >=80) {
			grade="A";
		}
		else if(score >=60) {
			grade="C";
		}
		else {
			grade="Fail";
		}
	}
	
	public double getAttendancePercentage() {
		return attendance_percentage;
	}


	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", sname=" + sname + ", course=" + course + ", attendance_percentage="
				+ attendance_percentage + ", score=" + score + ", grade=" + grade + "]";
	}
	
	
	
	
	
}
