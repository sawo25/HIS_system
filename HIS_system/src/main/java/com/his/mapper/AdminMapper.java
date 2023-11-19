package com.his.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.his.dtos.AdminDto;
import com.his.dtos.MediDto;

@Mapper
public interface AdminMapper {
	public AdminDto adminLogin(String id);
	
	public List<MediDto> getMediList();
}
