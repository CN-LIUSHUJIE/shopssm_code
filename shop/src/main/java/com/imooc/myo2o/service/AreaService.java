package com.imooc.myo2o.service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.imooc.myo2o.dto.AreaExecution;
import com.imooc.myo2o.entity.Area;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface AreaService {
	/**
	 * 
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	List<Map<String,Object>> getAreaList() throws JsonParseException, JsonMappingException,
			IOException;

	AreaExecution addArea(Area area);

	int updateArea(Area area);



}
