package com.sweet.repository;


import com.sweet.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by xc-sw on 2017/8/3.
 */
public interface StudentRepository extends JpaRepository<Student, Integer>{
    /**
     * 根据年龄查询
     * @param age
     * @return
     */
    public List<Student> findByAge(Integer age);
}
