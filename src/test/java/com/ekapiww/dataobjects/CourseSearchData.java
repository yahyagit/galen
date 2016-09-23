package com.ekapiww.dataobjects;

public class CourseSearchData {
	
	private String studentType;
	private String courseType;
	private String destination;
	private String studyFrom;
	private String studyPeriod;
	
	public CourseSearchData(String studentType,
							String courseType,
							String destination,
							String studyFrom,
							String studyPeriod) {
		this.studentType = studentType;
		this.courseType = courseType;
		this.destination = destination;
		this.studyFrom = studyFrom;
		this.studyPeriod = studyPeriod;
	}

	public String getStudentType() {
		return studentType;
	}

	public String getCourseType() {
		return courseType;
	}

	public String getDestination() {
		return destination;
	}

	public String getStudyFrom() {
		return studyFrom;
	}

	public String getStudyPeriod() {
		return studyPeriod;
	}
	
}
