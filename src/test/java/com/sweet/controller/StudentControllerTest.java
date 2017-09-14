package com.sweet.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {
    @Autowired
    private MockMvc mvc;
    @Test
    public void queryStudentList2() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/listtt"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void queryStudentList() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/student/query/list11"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

}