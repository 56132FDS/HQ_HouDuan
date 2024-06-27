package org.example.hq_houduan.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@TableName("student_table")
public class Student {
    private String name;
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer courseid;
    private Integer signin;

}
