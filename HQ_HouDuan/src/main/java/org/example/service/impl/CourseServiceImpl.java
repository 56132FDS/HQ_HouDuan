package org.example.service.impl;

import org.example.mapper.CourseMapper;
import org.example.pojo.Course;
import org.example.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> listForManager() {
        return courseMapper.listForManager();
    }

    @Override
    public List<Course> listForTeacher(int id) {
        return courseMapper.listForTeacher(id);
    }

    @Override
    public void delete(Integer id) {
        courseMapper.delete(id);
    }

    @Override
    public void add(Course course) {
        courseMapper.add(course);
    }
}
