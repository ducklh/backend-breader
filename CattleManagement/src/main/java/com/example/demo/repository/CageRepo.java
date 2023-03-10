package com.example.demo.repository;

import com.example.demo.model.Cage;

import com.example.demo.model.Employee;
import com.example.demo.model.Entities;
import com.example.demo.model.dto.CageForEditDto;
import com.example.demo.model.dto.EmployeeForCageDto;

import com.example.demo.model.dto.CageListDTO;
import com.example.demo.model.dto.GetEmployeeNameDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface CageRepo extends JpaRepository<Cage, String> {



    Optional<Cage> findByCageId(String Id);


    @Query(value = "select cage_id from cage",nativeQuery = true)
    List<String> getListCageId();


    @Query(value="select c.cage_id as cageId, c.employee_id as employeeId, c.created_date as createdDate, c.closed_date as closedDate, " +
            "c.quantity as quantity, e.employee_name as employeeName from cage c join employee e on c.employee_id = e.employee_id" +
            " where c.cage_id =? ", nativeQuery=true)
    Optional<CageForEditDto> findByCageId2(String Id);


    Boolean existsByCageId(String id);

    @Query(value="SELECT * FROM cages_seq", nativeQuery=true)
    Integer getNextId();

    @Query(value="select e.employee_name as employeeName, e.employee_id as employeeId from employee e join account a on e.account_id = a.account_id where a.account_name = ? limit 1", nativeQuery=true)
    EmployeeForCageDto getEmployeeIdAndName(String accountName);

    @Query(value = "select c.cage_id as cageId, c.closed_date as closedDate, c.created_date as createdDate, c.quantity,e.employee_name as employeeName,count(et.entities_id) as entitiesQuantity " +
            "from cage c left join employee e on c.employee_id=e.employee_id " +
            "left join entities et on c.cage_id=et.cage_id " +
            "group by c.cage_id",
            countQuery="select count(cage_id) from cage",nativeQuery=true)
    Page<CageListDTO> findAllCage(Pageable pageable);

    @Query(value = "select distinct e.employee_id as employeeId,e.employee_name as employeeName from employee e where e.is_delete!=1 or e.is_delete=null", nativeQuery = true)
    List<GetEmployeeNameDTO> getAllEmployeeName();

    @Query(value = "select c.cage_id as cageId, c.closed_date as closedDate, c.created_date as createdDate, c.quantity,e.employee_name as employeeName,count(et.entities_id) as entitiesQuantity " +
            "from cage c left join employee e on c.employee_id=e.employee_id left join entities et on c.cage_id=et.cage_id " +
            "where c.cage_id like ?1 and e.employee_id like ?2 and c.created_date>=?3 and c.created_date<=?4 "+
            "group by c.cage_id",
            countQuery="select count(c.cage_id) from cage c inner join  employee e on c.employee_id=e.employee_id  where c.cage_id like ?1 and e.employee_id like ?2 and c.created_date>=?3 and c.created_date<=?4 ",nativeQuery=true)
    Page<CageListDTO> findCageByCreatedDate(String cageId,String employeeId, String dateFrom, String dateTo,Pageable pageable);

    @Query(value = "select c.cage_id as cageId, c.closed_date as closedDate, c.created_date as createdDate, c.quantity,e.employee_name as employeeName,count(et.entities_id) as entitiesQuantity " +
            "from cage c left join employee e on c.employee_id=e.employee_id " +
            "left join entities et on c.cage_id=et.cage_id " +
            "where c.cage_id like ?1  and e.employee_id like ?2 and c.closed_date>=?3 and c.closed_date<=?4 "+
            "group by c.cage_id",
            countQuery="select count(c.cage_id) from cage c inner join employee e on  c.employee_id=e.employee_id where c.cage_id like ?1 and e.employee_id like ?2 and c.closed_date>=?3 and c.closed_date<=?4",nativeQuery=true)
    Page<CageListDTO> findCageByClosedDate(String cageId ,String employeeId,String dateFrom, String dateTo, Pageable pageable);

    @Query(value = "select count(entities_id) from entities where cage_id=?1 ", nativeQuery=true)
    Integer getEntitiesInCage(String cageId);

    @Transactional
    @Modifying
    @Query(value="update cage set closed_date=?1 where cage_id=?2", nativeQuery=true)
    void updateClosedDate(LocalDate closedDate, String cageId);
}