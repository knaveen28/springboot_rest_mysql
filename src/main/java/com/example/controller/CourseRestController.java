package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.Course;
import com.example.service.CourseService;

@RestController
public class CourseRestController {

	@Autowired
	private CourseService courseService;

	@PostMapping("/course")
	public ResponseEntity<String> createCourse(@RequestBody Course course) {
		String status = courseService.upsert(course);
		return new ResponseEntity<>(status, HttpStatus.CREATED);
	}

	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getAllCourses() {
		List<Course> allCourses = courseService.getAllCourses();
		return new ResponseEntity<>(allCourses, HttpStatus.OK);
	}

    @GetMapping("/course/{cid}")
	public ResponseEntity<Course> getCourse(@PathVariable Integer cid) {
		Course course = courseService.getById(cid);
		return new ResponseEntity<>(course, HttpStatus.OK);
	}

	

}

