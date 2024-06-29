package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 教师实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    private String name;
    private String id;
    private List<Integer> courseIDs;
    // 一般的数据库不支持数组数据类型，courseIDs要从courses表中查询得到
}
