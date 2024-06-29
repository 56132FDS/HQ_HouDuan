package org.example.service.impl;

import org.example.mapper.StudentMapper;
import org.example.pojo.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> list() {
        return studentMapper.list();
    }

    @Override
    public void save(Student student) {
        studentMapper.save(student);
    }

    @Override
    public void removeById(int id) {
        studentMapper.removeById(id);
    }

}
