package org.example.service;

import org.example.pojo.Student;

import java.util.List;

public interface StudentService {

    List<Student> list();

    void save(Student student);

    void removeById(int id);

    void updateById(Student student);
}
