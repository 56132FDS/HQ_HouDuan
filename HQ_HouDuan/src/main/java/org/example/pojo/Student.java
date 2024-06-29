package org.example.pojo;

import lombok.*;

/**
 * 学生实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String name;
    private Integer id;
    private Integer courseID;
    private Integer signIn;
}
