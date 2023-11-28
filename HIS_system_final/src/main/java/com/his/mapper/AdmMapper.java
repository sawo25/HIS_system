package com.his.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.aspectj.weaver.tools.cache.AsynchronousFileCacheBacking.InsertCommand;

import com.his.command.AdmInsertCommand;
import com.his.command.DiseasCommand;
import com.his.dtos.AdmDto;
import com.his.dtos.AdminDto;
import com.his.dtos.DigDto;
import com.his.dtos.MediDto;
import com.his.dtos.PtDto;

@Mapper
public interface AdmMapper {

	public List<AdmDto> admList(int adm_pt);
	
	public int admAdd(AdmDto dto);
	
	public AdmDto getAdm(int adm_seq);
	
	public boolean admUpdate(AdmDto dto);
	
	public void admDel(int adm_seq);

}
