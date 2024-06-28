package org.example.mapper;

import org.example.pojo.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseMapper {
    @Select("")
    List<Course> listForManager();

    List<Course> listForTeacher(int id);

    void delete(Integer id);

    void add(Course course);
}
