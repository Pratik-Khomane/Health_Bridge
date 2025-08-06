package com.hospital.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hospital.custom_exception.ResourceNotFoundException;
import com.hospital.dao.DepartmentDao;
import com.hospital.dao.UserDao;
import com.hospital.dto.ApiResponse;
import com.hospital.dto.DepartmentDTO;
import com.hospital.entities.Department;
import com.hospital.entities.User;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

	private final DepartmentDao departmentDao;
	private final UserDao userDao;
	private ModelMapper mapper;

	@Override
	public ApiResponse assignDepartment(Long userId, DepartmentDTO dto) {

		// 1. get UserEntityby its id
		User userEntity = userDao.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("Invalid UserEntityid - can;t link UserEntityaddress!!!!!"));
		// userEntity : persistent
		// 2. Check if Department already exists - if yes update it
		Department departmentEntity = userEntity.getDepartment();
		if (departmentEntity != null) {
			mapper.map(dto, departmentEntity);
			return new ApiResponse("address updated ....");
		}
		// 3 . new department, so link it to UserEntity.
		// map adr dto -> dept entity
		Department deptEntity = mapper.map(dto, Department.class);
		// 3 establish uni dir asso between entities : UserEntity1--->1 Address
		userEntity.setDepartment(deptEntity);// modifying state of persistent entity
		return new ApiResponse("address linked to UserEntity....");
	}// no run time exc -> tx.commit -> session.flush -> DML -> insert - adr , update
		// - users -> close

	@Override
	public DepartmentDTO getUserdepartment(Long userId) {
		Department address = departmentDao.fetchUserDepartment(userId).orElseThrow(
				() -> new ResourceNotFoundException("Invalid UserEntityid or Department not yet assigned !!!!"));
		return mapper.map(address, DepartmentDTO.class);
	}

}
