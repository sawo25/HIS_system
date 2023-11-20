package com.his.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.his.dtos.PtDto;

@Mapper
public interface PtMapper {

	public List<PtDto> getPtList();
	
	public boolean addPt(PtDto dto);


}
