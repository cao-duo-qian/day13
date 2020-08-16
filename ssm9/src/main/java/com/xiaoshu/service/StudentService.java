package com.xiaoshu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoshu.dao.CourseMapper;
import com.xiaoshu.dao.StudentMapper;
import com.xiaoshu.entity.Course;
import com.xiaoshu.entity.Student;
import com.xiaoshu.entity.StudentVo;

import redis.clients.jedis.Jedis;

@Service
public class StudentService {

	
	@Autowired
	StudentMapper studentMapper;
	
	@Autowired
	CourseMapper courseMapper;

	public PageInfo<StudentVo> findPage(StudentVo studentVo , Integer pageNum , Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<StudentVo> list = studentMapper.findList(studentVo);
		return new PageInfo<>(list);
	}
	
	public List<Course> findAll(){
		return courseMapper.selectAll();
	}
	
	public Course findByCode(String code){
			Course c = new Course();
			c.setName(code);
			return courseMapper.selectOne(c);
	}
	
	public Student findByName(String name){
		Student s = new Student();
		s.setName(name);
		return studentMapper.selectOne(s);
	}
	
	public void addStudent(Student student){
		studentMapper.insert(student);
		Jedis j = new Jedis("127.0.0.1",6379);
		
		Student s = new Student();
		s.setName(student.getName());
		Student student2 = studentMapper.selectOne(s);
		
		j.set(student2.getId()+"", student2.getName());
		
		j.hset("学生信息",student2.getId()+"" , student2.getName());
		
		
	}
	public void updateStudent(Student student){
		studentMapper.updateByPrimaryKeySelective(student);
	}
	public void deleteStudent(Integer id){
		studentMapper.deleteByPrimaryKey(id);
	}
	public List<StudentVo> countStudent(){
		return studentMapper.countStudent();
	}
	
	public void addC(Course course){
		courseMapper.insert(course);
	}
	
	
}
