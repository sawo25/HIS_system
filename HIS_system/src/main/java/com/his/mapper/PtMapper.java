package com.his.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.his.command.DiseasCommand;
import com.his.dtos.AdminDto;
import com.his.dtos.MediDto;
import com.his.dtos.PtDto;

@Mapper
public interface PtMapper {

	public List<PtDto> getPtList();
	
	public boolean addPt(PtDto dto);

	public PtDto getPt(int pt_seq);

	public boolean ptUpdate(PtDto dto);

	public void ptDel(int pt_seq);
	
	public MediDto mediLogin(int medi_seq);

	public boolean diseasUpdate(String diseas, int pt_seq);
}
