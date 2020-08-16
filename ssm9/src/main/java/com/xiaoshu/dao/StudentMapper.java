package com.xiaoshu.dao;

import java.util.List;

import com.xiaoshu.base.dao.BaseMapper;
import com.xiaoshu.entity.Course;
import com.xiaoshu.entity.Student;
import com.xiaoshu.entity.StudentVo;

public interface StudentMapper extends BaseMapper<Student> {
	public List<StudentVo> findList(StudentVo studentVo);
	public List<Course> addC(Course course);
	public List<StudentVo> countStudent();
}