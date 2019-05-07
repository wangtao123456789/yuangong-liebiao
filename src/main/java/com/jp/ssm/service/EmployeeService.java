package com.jp.ssm.service;

import com.jp.ssm.bean.Employee;
import com.jp.ssm.bean.EmployeeExample;
import com.jp.ssm.bean.EmployeeExample.Criteria;
import com.jp.ssm.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;
//查询所有员工
    public List<Employee> getAll(){
       return employeeMapper.selectByExampleWithDept(null);
    }


    //员工保存方法
    public void saveEmp(Employee employee) {
        employeeMapper.insertSelective(employee);
        System.out.println("this is page ");
    }

    //检验用户名是否可用 ,放回true 代表当前名字可用。
    public boolean checkUser(String empName) {
        EmployeeExample example = new EmployeeExample();
        //有问题视频25,04分。
//        example.createCriteria().andEmpNameEqualTo(empName);
         Criteria criteria = example.createCriteria();
        criteria.andEmpNameEqualTo(empName);
        long count = employeeMapper.countByExample(example);
        return count ==0;
    }

    //按照员工id查询员工
    public Employee getEmp(Integer id) {
        Employee employee = employeeMapper.selectByPrimaryKey(id);
        return employee;
    }


    //员工更新
    public void updateEmp(Employee employee) {
        System.out.println(employee);
        employeeMapper.updateByPrimaryKeySelective(employee);
    }

    //删除员工的方法
    public void deleteEmp(Integer id) {
        employeeMapper.deleteByPrimaryKey(id);
    }

    public void deleteBatch(List<Integer> ids) {
        EmployeeExample example = new EmployeeExample();
        Criteria criteria = example.createCriteria();
        criteria.andEmpIdIn(ids);
        employeeMapper.deleteByExample(example);
    }
}
//    public List<Employee> getAll()
//    {
//        return employeeMapper.selectByExample(null);
//    }
//}
