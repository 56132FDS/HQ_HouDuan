package org.example.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.Student;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("select * from students")
    List<Student> list();

    @Insert("insert into students (name, sign_in, course_id) values (#{name}, #{signIn}, #{courseID})")
    void save(Student student);

    @Delete("delete from students where id = #{id}")
    void removeById(int id);

}
