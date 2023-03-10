package com.example.demo.repository;

import com.example.demo.model.category.CatDistrict;
import com.example.demo.model.dto.DistrictListDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DistrictRepo extends JpaRepository<CatDistrict,String> {
    @Query(value = "SELECT c.district_id as districtId, c.district_name as districtName FROM cat_district c where c.province_id =? order by c.district_name;",nativeQuery=true)
    List<DistrictListDTO> getDistrictList(Integer id);
}
