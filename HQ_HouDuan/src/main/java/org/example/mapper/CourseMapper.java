package org.example.mapper;

import org.example.pojo.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseMapper {
    @Select("select * from courses")
    List<Course> listForManager();

    @Select("select * from courses where id = #{id}")
    List<Course> listForTeacher(int id);

    @Delete("delete from courses where id = #{id}")
    void delete(Integer id);

    @Insert("insert into courses (name, start, end, teacher_id) values (#{name}, #{start}, #{end}, #{teacherID})")
    void add(Course course);
}
