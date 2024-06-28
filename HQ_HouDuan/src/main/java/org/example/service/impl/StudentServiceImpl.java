package org.example.service.impl;

import org.example.pojo.Student;
import org.example.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Override
    public List<Student> list() {
        return null;
    }

    @Override
    public void save(Student student) {

    }

    @Override
    public void removeById(int id) {

    }

    @Override
    public void updateById(Student student) {

    }
}
