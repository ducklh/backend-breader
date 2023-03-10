package com.example.demo.service;

import com.example.demo.model.dto.DistrictListDTO;
import com.example.demo.model.dto.ProvinceDTO;
import com.example.demo.model.dto.WardDTO;

import java.util.List;

public interface CategoryService {
    List<ProvinceDTO> getProvinceList();
    List<DistrictListDTO> getDistrictList(Integer provinceName);
    List<WardDTO> getWardsList(Integer districtName);
}
