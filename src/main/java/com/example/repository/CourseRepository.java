package com.example.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dto.Course;

public interface CourseRepository extends JpaRepository<Course, Serializable> {

}
