package com.sweet.controller;

import com.sweet.domain.Student;
import com.sweet.repository.StudentRepository;
import com.sweet.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xc-sw on 2017/8/3.
 */
@RestController
public class StudentController {
    private  final static Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentService studentService;

    /**
     * 查询所有的学生列表
     *
     * @return
     */
    @GetMapping(value = "/student/query/list")
    public List<Map<String, Object>> queryStudentList() {
        logger.info("查询学生列表~");
        List<Student> list = studentRepository.findAll();
        Map<String, Object> map = null;
        List<Map<String, Object>> mList = new ArrayList<>();
        if (list != null && list.size() > 0) {
            for (Student elem : list) {
                map = new HashMap<String, Object>();
                map.put("id", elem.getId());
                map.put("title", elem.getName());
                map.put("age", elem.getAge());
                mList.add(map);
            }
        }
        return mList;
    }

    /**
     * 添加一个学生
     *
     * @param name
     * @param age
     * @return
     */
    @PostMapping(value = "/student/save")
    public Student saveStudent(@RequestParam("name") String name,
                               @RequestParam("age") Integer age) {
        Student student = new Student();
        student.setAge(age);
        student.setName(name);
        return studentRepository.save(student);
    }

    /**
     * 根据id查询一个学生
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/student/{id}")
    public Student getStudentDetail(@PathVariable("id") Integer id) {
        return studentRepository.findOne(id);
    }

    /**
     * 根据id修改学生
     *
     * @param id
     * @param newName
     * @param newAge
     * @return
     */
    @PutMapping(value = "/student/update/{id}")
    public Student updateStudent(@PathVariable("id") Integer id,
                                 @RequestParam("name") String newName,
                                 @RequestParam("age") Integer newAge) {
        Student st = new Student();
        st.setId(id);
        st.setName(newName);
        st.setAge(newAge);
        return studentRepository.save(st);

    }

    /**
     * 根据id删除学生
     *
     * @param delId
     */
    @DeleteMapping(value = "/student/delete/{id}")
    public void deleteStudent(@PathVariable("id") Integer delId) {
        studentRepository.delete(delId);
    }

    /**
     * 根据年龄查询学生
     *
     * @param age
     * @return
     */
    @GetMapping(value = "/student/query/{age}")
    public List<Student> queryStudentByAge(@PathVariable("age") Integer age) {
        return studentRepository.findByAge(age);
    }

    @PostMapping(value = "/student/save/two")
    public void saveTwoStudent() {
        studentService.saveTwoStudent();
    }

    @GetMapping(value = "/student/if/allow/{id}")
    public void isAllowIn(@PathVariable("id") Integer id) throws Exception{
        studentService.isAllow(id);
    }

    /**
     * 查询所有的学生列表
     *
     * @return
     */
    @GetMapping(value = "/list")
    public List<Student> queryStudentList2() {
        return studentRepository.findAll();
    }
}
