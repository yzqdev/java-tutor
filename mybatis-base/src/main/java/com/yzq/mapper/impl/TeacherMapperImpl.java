package com.yzq.mapper.impl;

import com.yzq.mapper.TeacherMapper;
import com.yzq.model.Teacher;
import com.yzq.model.User;
import com.yzq.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;

/**
 * @author yzq
 * @description
 * @date:Created time 2021/8/21 23:55
 * @modified By:
 */
public class TeacherMapperImpl implements TeacherMapper {
    @Override
    public Integer saveTeacher(Teacher teacher) {
        try (SqlSession session = MybatisUtil.getSqlSessionFactory()) {
            TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
            int flag = teacherMapper.saveTeacher(teacher);
            session.commit();
            return flag;
        }
    }

    @Override
    public Teacher getTeacherById(int id) {
        try (SqlSession session = MybatisUtil.getSqlSessionFactory()) {
            TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
            Teacher teacher= teacherMapper.getTeacherById(id);
            session.commit();
            return teacher;
        }
    }

    @Override
    public List<Teacher> getTeachers(HashMap hashMap) {
        try (SqlSession session = MybatisUtil.getSqlSessionFactory()) {
            TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
            List<Teacher> teachers = teacherMapper.getTeachers( hashMap);
            session.commit();
            return teachers;
        }
    }

    @Override
    public int updateTeacher(Integer id, Teacher teacher) {
        try (SqlSession session = MybatisUtil.getSqlSessionFactory()) {
            TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
            int flag=teacherMapper.updateTeacher(id,teacher);
            session.commit();
            return flag;
        }
    }
}
