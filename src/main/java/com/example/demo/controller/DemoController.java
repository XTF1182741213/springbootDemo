package com.example.demo.controller;

import com.example.demo.entity.Student;
import org.springframework.web.bind.annotation.*;

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

    /**
     * @Date:17:02 2018/7/30
     * @Description: Get
     * @Param:  * @param age
     * @param name
     * @Return:
     */
    @GetMapping(value="/testget/{age}/{name}")
    public String getStudent(@PathVariable("age") int age,@PathVariable("name") String name){

        Student student1=new Student(age,name);
        return student1.toString();
    }

    /**
     * @Date:17:02 2018/7/30
     * @Description:Post
     * @Param:  * @param student
     * @Return:
     */
    @PostMapping(value="/testpost",consumes="application/json;charset=utf-8")
    public String postStudent(@RequestBody Student student){
        return student.getAge()+"   "+student.getName();
    }

    /**
     * @Date:17:03 2018/7/30
     * @Description:Put
     * @Param:
     * * @param student
     * @Return:
     */
    @PutMapping(value="/testput",consumes="application/json;charset=utf-8")
    public String putStudent(@RequestBody Student student){
        return student.getAge()+"   "+student.getName();
    }

    /**
     * @Date:17:03 2018/7/30
     * @Description:Delete
     * @Param:  * @param student
     * @Return:
     */
    @DeleteMapping(value="/testdelete")
    public String deleteStudent(@RequestParam(value="age") int age,@RequestParam(value="name") String name){
        Student student2=new Student(age,name);
        return student2.toString();
    }

}
