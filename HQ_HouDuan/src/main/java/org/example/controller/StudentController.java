package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Options;
import org.example.pojo.Result;
import org.example.pojo.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    public Result list(){
        log.info("My info");
        List<Student> studentList = studentService.list();
        return Result.success(studentList);
    }

    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    @PostMapping("/add")
    public Result add(@RequestBody Student student){
        log.info("student = {}",student);
        studentService.save(student);
        return Result.success();
    }


    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id){
        studentService.removeById(id);
        return Result.success();
    }
    @PutMapping("/update/{id}")
    public Result update(@RequestBody Student student,@PathVariable int id){
        log.info("student = {}",student);
        student.setId(id);
        studentService.updateById(student);
        return Result.success();
    }
}
