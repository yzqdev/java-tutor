package com.yzq.mapper;

import com.yzq.model.Teacher;
import com.yzq.model.User;

import java.util.HashMap;
import java.util.List;

/**
 * @author yzq
 * @description
 * @date:Created time 2021/8/21 15:42
 * @modified By:
 */
public interface TeacherMapper {
    Integer saveTeacher(Teacher teacher);

    Teacher getTeacherById(int id);

    List<Teacher> getTeachers(HashMap hashMap);

    int updateTeacher(Integer id, Teacher teacher);
}
