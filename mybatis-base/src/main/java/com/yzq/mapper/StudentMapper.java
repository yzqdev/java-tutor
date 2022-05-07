package com.yzq.mapper;

import com.github.pagehelper.Page;
import com.yzq.model.Student;
import com.yzq.model.Teacher;

import java.util.List;

/**
 * @author yzq
 * @description
 * @date:Created time 2021/8/21 15:42
 * @modified By:
 */
public interface StudentMapper {
   Page<Student> getStudents();
    List<Student> getStudentss();
    Integer saveStudent(Student student);
    Teacher getTeacher(Integer id);
}
