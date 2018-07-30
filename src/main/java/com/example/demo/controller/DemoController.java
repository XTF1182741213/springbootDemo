package com.example.demo.controller;

import com.example.demo.entity.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
/**
 * @Author:fly
 * @Description:
 * @Date:11:38 2018/7/30
 */
@RestController
public class DemoController {
    /**
     * @Date:11:38 2018/7/30
     * @Description:
     * @Param:  * @param 
     * @Return:
     */
    @RequestMapping(value="/hello",method=RequestMethod.GET)
    public List<Student> Hello(){
        List<Student> students=new ArrayList<>();
        students.add(new Student(21,"fly"));
        students.add(new Student(22,"xiaofei"));
        return students;
    }

    /**
     * @Date:11:38 2018/7/30
     * @Description:
     * @Param:  * @param age
     * @param name
     * @Return:
     */
    @RequestMapping(value="/login",method=RequestMethod.GET)
    public Student loginStudent(int age,String name){
       Student student=new Student(age,name);
       return student;
      // this.mvc.preform(get("/users".accept(MediaType.Text).andExpect(status().isOk()).andDo(documlment("list-users"))));

    }

}
