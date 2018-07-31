package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {
    @Autowired
    private MockMvc mvc;

    /**
     * @Date:16:47 2018/7/31
     * @Description:
     * @Param:  * @param
     * @Return:
     */
    @Test
    public void getProduct() throws Exception {
        String responseString = mvc.perform(
                MockMvcRequestBuilders.get("/getproduct")    //请求的url,请求的方法是get
                        .contentType(MediaType.APPLICATION_JSON)  //数据的格式
        ).andExpect(MockMvcResultMatchers.status().isOk())    //返回的状态是200
                .andDo(print())         //打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串
        //.andExpect(MockMvcResultMatchers.content().string("365"));  //测试接口返回内容
    }

    /**
     * @Date:16:47 2018/7/31
     * @Description:
     * @Param:  * @param
     * @Return:
     */
    @Test
    public void getProductJson() throws Exception{
        String responseJson=mvc.perform(
                MockMvcRequestBuilders.get("/getproductjson")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andReturn().getResponse().getContentAsString();

    }


}
