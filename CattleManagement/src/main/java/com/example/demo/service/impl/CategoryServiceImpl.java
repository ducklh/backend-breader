package com.example.demo.service.impl;

import com.example.demo.model.dto.DistrictListDTO;
import com.example.demo.model.dto.ProvinceDTO;
import com.example.demo.model.dto.WardDTO;
import com.example.demo.repository.DistrictRepo;
import com.example.demo.repository.ProvinceRepo;
import com.example.demo.repository.WardRepo;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    ProvinceRepo provinceRepo;
    @Autowired
    DistrictRepo districtRepo;
    @Autowired
    WardRepo wardRepo;
    @Override
    public List<ProvinceDTO> getProvinceList() {
        return provinceRepo.getProvinceList();
    }

    @Override
    public List<DistrictListDTO> getDistrictList(Integer provinceName) {
        return districtRepo.getDistrictList(provinceName);
    }

    @Override
    public List<WardDTO> getWardsList(Integer districtName) {
        return wardRepo.getWardList(districtName);
    }
}
