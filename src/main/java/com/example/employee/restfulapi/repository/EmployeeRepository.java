package com.example.employee.restfulapi.repository;

import com.example.employee.restfulapi.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    /*//以下所有的*都代表变量

    //1.查询名字是*的第一个employee
    Employee findFirstByName(String name);

    //2.找出Employee表中第一个姓名包含`*`字符并且薪资大于*的雇员个人信息

    Employee findFirstByNameContainsAndSalaryGreaterThan(String containValue, int salary);
    //3.找出一个薪资最高且公司ID是*的雇员以及该雇员的姓名

    @Query(value = "select * from Employee where companyId = ?1 order by salary desc limit 1",nativeQuery = true)
    Employee findEmployeeByCompanyIdAndMaxSalary(int companyId);
    //4.实现对Employee的分页查询，每页两个数据

    @Override
    Page<Employee> findAll(Pageable pageable);

    //5.查找**的所在的公司的公司名称

    Employee findByName(String name);

    //6.将*的名字改成*,输出这次修改影响的行数

    @Modifying
    @Query("update Employee e set e.name = ?1 where e.name = ?2")
    int modifyByName(String newName, String name);
    //7.删除姓名是*的employee

    @Modifying
    @Query("delete from Employee where name = ?1")
    void deleteByName(String name);*/

    List<Employee> findAllByGender(String gender);
}
