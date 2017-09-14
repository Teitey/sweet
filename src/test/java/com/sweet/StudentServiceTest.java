package com.sweet;

import com.sweet.domain.Student;
import com.sweet.service.StudentService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 学生服务类测试
 *
 * @author sweet
 * @create 2017-08-16 17:17
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {
    @Autowired
    private StudentService studentService;

    @Test
    public void findOneTest(){
        Student st =studentService.findOne(1);
        Assert.assertEquals(new Integer(10),st.getAge());
    }


}
