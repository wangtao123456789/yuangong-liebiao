package com.jp.ssm.controller;


//处理和不门有关的请求


import com.jp.ssm.bean.Department;
import com.jp.ssm.bean.Msg;
import com.jp.ssm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
//@RequestMapping("/test1")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

//    返回所有的部门信息

    @RequestMapping("/depts")
    @ResponseBody
    public Msg getDepts(){
        //查出所有的部门信息
        List<Department> list = departmentService.getDepts();
        return Msg.success().add("depts", list);
    }
}
