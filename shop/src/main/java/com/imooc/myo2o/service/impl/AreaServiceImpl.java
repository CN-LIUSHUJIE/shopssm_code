package com.imooc.myo2o.service.impl;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.imooc.myo2o.dao.AreaDao;
import com.imooc.myo2o.dto.AreaExecution;
import com.imooc.myo2o.entity.Area;
import com.imooc.myo2o.enums.AreaStateEnum;
import com.imooc.myo2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreaDao areaDao;

	private static String AREALISTKEY = "arealist";


	@Override
	public List<Area> getAreaList() throws JsonParseException, JsonMappingException, IOException {

		List<Area> areaList = areaDao.queryArea();

		return areaList;
	}
}
