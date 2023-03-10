package com.example.demo.repository;

import com.example.demo.model.category.CatProvince;
import com.example.demo.model.dto.ProvinceDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvinceRepo extends JpaRepository<CatProvince ,String> {
    @Query(value = "select cat_province.province_id as provinceId,cat_province.province_name as provinceName from cat_province order by cat_province.province_name",nativeQuery=true)
    List<ProvinceDTO> getProvinceList();

}
