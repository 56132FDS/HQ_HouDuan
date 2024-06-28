package org.example.service;

import org.example.pojo.Course;

import java.util.List;

public interface CourseService {

    List<Course> listForManager();

    List<Course> listForTeacher(int id);

    void delete(Integer id);

    void add(Course course);
}
