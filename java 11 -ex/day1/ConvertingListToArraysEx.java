package com.training;

import java.util.List;

class Student {
	private int sId;
	private String sName;

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	@Override
	public String toString() {
		return "Student [sId=" + sId + ", sName=" + sName + "]";
	}

	public Student(int sId, String sName) {
		super();
		this.sId = sId;
		this.sName = sName;
	}

}

public class ConvertingListToArraysEx {
	public static void main(String[] args) {
		List<Student> studentList = List.of(new Student(101, "Kumar"), new Student(102, "harish"));
		Student[] studentArray = studentList.toArray(new Student[studentList.size()]);

		for (Student temp : studentArray) {
			System.out.println(temp);
		}

		// Now that we have a method which returns an array of specified 
		// type T. Why do we need another function? Is there a better way 
		// to handle it? In Java 11 
		
		Student[] studentArray1 = studentList.toArray(Student[]::new);
		for (Student temp : studentArray1) {
			System.out.println(temp);
		}
	}
}
