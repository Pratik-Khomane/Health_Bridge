package com.hospital.service;

import com.hospital.dto.ApiResponse;
import com.hospital.dto.DepartmentDTO;

public interface DepartmentService {

	ApiResponse assignDepartment(Long userId, DepartmentDTO dto);
	
	DepartmentDTO getUserdepartment(Long userId);
}
