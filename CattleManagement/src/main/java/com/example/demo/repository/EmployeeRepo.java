package com.example.demo.repository;


import com.example.demo.model.dto.EmployeeDTO;
import com.example.demo.model.dto.EmployeeFindIdDTO;
import com.example.demo.model.dto.EmployeeListDTO;
import com.example.demo.model.Employee;

import com.example.demo.model.dto.EmployeeForCageDto;

import com.example.demo.model.dto.GetEmployeeNameDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.List;

@Transactional
@Repository
public interface EmployeeRepo extends PagingAndSortingRepository<Employee, String> {

    @Query(value =  "select e.employee_id as employeeId, e.employee_name as employeeName, e.avatar, e.birthday, \n" +
                    "e.id_card as idCard, e.address, e.gender, e.email, e.is_delete as isDelete, \n" +
                    "a.account_name as accountName from employee e \n" +
                    "join account a on a.account_id = e.account_id \n" +
                    "where e.employee_name like ?1 and e.employee_id like ?2 and is_delete!=1 \n" +
                    "group by e.employee_id",
                    countQuery="select count(employee_id) from employee", nativeQuery = true)
    Page<EmployeeListDTO> findAllEmployeeByNameAndId(String searchName, String searchId, Pageable pageable);

    @Query(value =  "select e.employee_id as employeeId, e.employee_name as employeeName, e.avatar, e.birthday, \n" +
                    "e.id_card as idCard, e.address, e.gender, e.email, e.is_delete as isDelete, \n" +
                    "a.account_name as accountName from employee e \n" +
                    "inner join account a on a.account_id = e.account_id \n" +
                    "where is_delete!=1 \n" +
                    "group by e.employee_id",
                    countQuery="select count(employee_id) from employee", nativeQuery = true)
    Page<EmployeeListDTO> findAllEmployee(Pageable pageable);

    @Query(value =  "select e.employee_id as employeeId, e.employee_name as employeeName, e.avatar, e.birthday, \n" +
                    "e.id_card as idCard, e.address, e.gender, e.email, e.is_delete as isDelete, \n" +
                    "e.account_id as accountId, a.account_name as accountName, a.password as password from employee e \n" +
                    "inner join account a on a.account_id = e.account_id \n" +
                    "where e.employee_id=?1", nativeQuery = true)
    Optional<EmployeeFindIdDTO> findEmployeeById(String Id);

    @Modifying
    @Query(value =  "insert into employee(employee_id, employee_name, birthday, avatar, id_card, address, gender, email, " +
                    "account_id, is_delete) values (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10)", nativeQuery = true)
    void createNewEmployee(String employeeId, String employeeName, String birthday,
                           String avatar, String idCard, String address, String gender,
                           String email, Long accountId, Boolean isDelete);

    @Transactional
    @Modifying
    @Query(value =  "update employee as e set e.employee_name = ?1, e.birthday = ?2, e.id_card = ?3,"+
                    " e.address = ?4, e.gender = ?5, e.email =?6 where e.employee_id = ?7", nativeQuery = true)
    void editEmployee(String employeeName, String birthday, String idCard,
                      String address, String gender, String email, String employeeId);

    @Modifying
    @Transactional
    @Query(value = "update employee set is_delete = 1 where employee_id = ? ", nativeQuery = true)
    void deleteEmployee(String id);

    @Query(value="select current_index from auto_id where group_code=13", nativeQuery = true)
    Integer getNextId();


    @Modifying
    @Transactional
    @Query(value = "update auto_id set current_index=current_index+1 where group_code=13", nativeQuery = true)
    void updateAutoRender();


//    @Query(value =  "select employee.employee_id as employeeId, employee.employee_name as employeeName, employee.birthday, \n" +
//                    "employee.id_card as idCard, employee.address, employee.gender, employee.email, \n" +
//                    "employee.account_name as accountName, employee.account_password as accountPassword from employee \n" +
//                    "left join account on account.account_id = employee.account_id \n" +
//                    "where employee.employee_id like ?1", nativeQuery = true)
//    Page<Employee> findById(String Id, Pageable pageable);


    // thangTD use to create Cage
    Boolean existsByEmployeeId(String id);

    @Query(value = "SELECT e.employee_id as employeeId, e.employee_name as employeeName FROM employee e where is_delete!=1 or is_delete=null", nativeQuery = true)
    List<EmployeeForCageDto> getAllEmployee();

    @Query(value = "SELECT * FROM employee  where employee_id=?", nativeQuery = true)
    Employee findEmpById(String id);
}
