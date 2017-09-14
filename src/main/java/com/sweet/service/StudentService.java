package com.sweet.service;

import com.sweet.domain.Student;
import com.sweet.enums.ResultEnum;
import com.sweet.exception.StudentException;
import com.sweet.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xc-sw on 2017/8/3.
 */
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Transactional
    public void saveTwoStudent(){
        Student st1 = new Student();
        st1.setAge(11);
        st1.setName("Tuqi");
        studentRepository.save(st1);

        /*int a = 1;
        int b = 0;

        System.out.print(a/b);*/

        Student st2 = new Student();
        st2.setAge(12);
        st2.setName("Xqiiiiiii");
        studentRepository.save(st2);

    }

    /**
     * 根据年龄查询是否被允许
     * @param id
     */
    public void isAllow(Integer id) throws Exception{
        Student student = studentRepository.findOne(id);
        if(student == null){
            throw new StudentException(ResultEnum.RECORD_EMPTY);
        }
        Integer age = student.getAge();
        if(age < 12){
            throw new StudentException(ResultEnum.ALLOW_NO);
        }else{
            throw new StudentException(ResultEnum.ALLOW_YES);
        }
    }

    /**
     * 根据id查询一个学生
     * @return
     */
    public Student findOne(Integer id){
        return studentRepository.findOne(id);
    }
}
