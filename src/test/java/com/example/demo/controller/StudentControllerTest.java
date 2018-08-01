package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void getStudent() throws Exception {

        String responseString = mvc.perform(
                MockMvcRequestBuilders.get("/testget/21/fly")    //请求的url,请求的方法是get
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)  //数据的格式
        ).andExpect(MockMvcResultMatchers.status().isOk())    //返回的状态是200
                .andDo(print())         //打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串
        //.andExpect(MockMvcResultMatchers.content().string("365"));  //测试接口返回内容
        log.info("test /testget Api interface");
    }

    @Test
    public void postStudent() throws Exception {
        Student student3=new Student(22,"fly");
        String requestJson= JSONObject.fromObject(student3).toString();
        mvc.perform(MockMvcRequestBuilders
                .post("/testpost")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
        log.info("test /testpost Api interface");
    }

    @Test
    public void putStudent() throws Exception {
        Student student4=new Student(23,"tengfei");
        String studentJson=JSONObject.fromObject(student4).toString();
        mvc.perform(MockMvcRequestBuilders
                .put("/testput")
                .contentType(MediaType.APPLICATION_JSON)
        .content(studentJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
        log.info("test /testput Api interface");
    }

    @Test
    public void deleteStudent() throws Exception {

        ObjectMapper mapper=new ObjectMapper();
        mvc.perform(MockMvcRequestBuilders
                    .delete("/testdelete")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                     .param("age","21")
                      .param("name","fly"))
                     .andExpect(MockMvcResultMatchers.status().isOk())
                     .andDo(print());
        log.info("test /testdelete Api interface");


    }
}
