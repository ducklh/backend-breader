package com.example.demo.repository;

import com.example.demo.model.category.CatWard;
import com.example.demo.model.dto.WardDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface WardRepo extends JpaRepository<CatWard, String> {

    @Query(value = "select w.ward_id as wardId,w.ward_name as wardName from cat_ward w where district_id=?1 order by w.ward_name",nativeQuery=true)
    List<WardDTO> getWardList(Integer id);
}
