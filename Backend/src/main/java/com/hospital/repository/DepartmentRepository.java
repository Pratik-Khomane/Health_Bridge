package com.hospital.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hospital.entities.Department;

public interface DepartmentDao extends JpaRepository<Department, Long> {

	@Query("select u.department from User u where u.id=:userId")
	Optional<Department> fetchUserDepartment(Long userId);

	

}
