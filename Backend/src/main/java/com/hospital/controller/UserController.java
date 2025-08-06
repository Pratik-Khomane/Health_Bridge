package com.hospital.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.dto.DepartmentDTO;
import com.hospital.service.DepartmentService;
import com.hospital.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
	//depcy
	private final UserService userService;
	private final DepartmentService departmentService;
	/*
	 * Assign user address | Update existing one.
	 * Ideally create another end point to update existing address 
	 * - with @PutMapping
URL - http://host:port/users/{userId}/address
Method - POST
Payload - address dto
error resp - ApiResp dto - SC 400 , mesg - linking adr failed
success resp - ApiResp dto - success mesg
	 */
	@PostMapping("/{userId}/department")
	@Operation(description = "Assign new address or update existing address")
	public ResponseEntity<?> assignOrUpdateUserAddress(
			@PathVariable Long userId,@RequestBody DepartmentDTO dto) {
		System.out.println("assign adr ");
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(departmentService.assignDepartment(userId,dto));
	}
	
	/*
	 * Fetch user address
		URL - http://host:port/users/{userId}/address
		Method - GET
		Payload - none
		error resp - ApiResp dto - SC 404 , 
		success resp - Address dto - success mesg
	 */
	@GetMapping("/{userId}/department")
	public ResponseEntity<?> getUserDepartment(@PathVariable Long userId)
	{
		System.out.println("in get adr "+userId);
		return ResponseEntity
				.ok(departmentService.getUserdepartment(userId));
	}
	

}
