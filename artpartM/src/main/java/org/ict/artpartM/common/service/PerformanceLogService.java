package org.ict.artpartM.common.service;



import org.ict.artpartM.common.domain.PerformanceLog;

import java.util.List;



public interface PerformanceLogService {

	public void register(PerformanceLog performanceLog) throws Exception;

	public List<PerformanceLog> list() throws Exception;

}
