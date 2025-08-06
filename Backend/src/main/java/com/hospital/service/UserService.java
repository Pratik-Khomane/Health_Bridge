package com.hospital.service;

import com.hospital.dto.SignupRequestDTO;
import com.hospital.dto.UserRespDTO;

import jakarta.validation.Valid;

public interface UserService {

	UserRespDTO signUp(@Valid SignupRequestDTO dto);

}
