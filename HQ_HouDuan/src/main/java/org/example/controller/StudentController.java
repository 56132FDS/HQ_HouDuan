package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Result;
import org.example.pojo.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public Result list(){
        log.info("查询全部学生信息，管理员、教师看到的界面相同");
        List<Student> studentList = studentService.list();
        return Result.success(studentList);
    }

    @PostMapping("/")
    public Result add(@RequestBody Student student){
        // 前端提供的student对象中的id无意义
        log.info("student = {}",student);
        studentService.save(student);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable int id){
        studentService.removeById(id);
        return Result.success();
    }

}
