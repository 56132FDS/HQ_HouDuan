package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Course;
import org.example.pojo.Result;
import org.example.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    /**
     * 管理员界面，查询出所有课程
     */
    @GetMapping("/courses")
    public Result listForManager(){
        log.info("查询全部课程");
        List<Course> courseList = courseService.listForManager();
        return Result.success(courseList);
    }

    /**
     * 教师界面，查询出该教师的所有课程
     */
    @GetMapping("/courses/{id}")
    public Result listForTeacher(@PathVariable Integer id){
        log.info("查询ID为{}的教师的课程",id);
        List<Course> courseList = courseService.listForTeacher(id);
        return Result.success(courseList);
    }

    /**
     * 管理员界面，删除课程
     */
    @DeleteMapping("/courses/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("删除ID为{}的课程",id);
        courseService.delete(id);
        return Result.success();
    }

    /**
     * 管理员界面，添加课程
     */
    @PostMapping("/courses")
    public Result add(@RequestBody Course course){
        log.info("添加课程：{}",course);
        courseService.add(course);
        return Result.success();
    }
}
