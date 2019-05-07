package com.jp.ssm.test;




import com.jp.ssm.bean.Department;
import com.jp.ssm.bean.Employee;
import com.jp.ssm.dao.DepartmentMapper;
import com.jp.ssm.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

//1.导入SpringTest模块
//2@ContextConfiguration指定Spring配置文件的位置
//3直接使用@autowired需要使用的组件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})


public class MapperTest {

    @Autowired
    DepartmentMapper departmentMapper;
    //测试DpartmentMapper
    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession sqlSession;
    @Test
    public void testCRUD(){


        System.out.println(departmentMapper);
        //1.插入几个部门
//        departmentMapper.insertSelective((new Department(1, "开发部")));
//        departmentMapper.insertSelective((new Department(2,"测试部")));
        //2.插入一个员工信息的测试
//         employeeMapper.insertSelective(new Employee(null,"wangtao","M","wangtao@qq.com",1));

        EmployeeMapper  mapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i = 0; i<1000;i++){
            String uid= UUID.randomUUID().toString().substring(0,5)+i;
            mapper.insertSelective(new Employee(null,uid,"M",uid+"@atguigu",1));

        }
    }
}
