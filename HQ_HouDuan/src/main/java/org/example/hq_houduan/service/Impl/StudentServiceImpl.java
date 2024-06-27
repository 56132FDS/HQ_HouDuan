package org.example.hq_houduan.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.hq_houduan.mapper.StudentMapper;
import org.example.hq_houduan.pojo.Student;
import org.example.hq_houduan.service.IStudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
