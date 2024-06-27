package org.example.hq_houduan.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Options;
import org.example.hq_houduan.mapper.StudentMapper;
import org.example.hq_houduan.pojo.Result;
import org.example.hq_houduan.pojo.Student;
import org.example.hq_houduan.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "30")int pageSize){
        log.info("My info");
        Page<Student>page = new Page<>(pageNum,pageSize);
        IPage<Student> pageResult = studentService.page(page);
        return Result.success(pageResult);
    }

    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    @PostMapping("/add")
    public Result add(@RequestBody Student student){
        log.info("student = {}",student);
        studentService.save(student);
        return Result.success(student);
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
    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable int id){
        Student student = studentService.getById(id);
        log.info("student = {}",student);
        return Result.success(student);
    }
}
