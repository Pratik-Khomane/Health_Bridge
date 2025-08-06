package com.hospital.service;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hospital.custom_exception.ApiException;
import com.hospital.dao.UserDao;
import com.hospital.dto.SignupRequestDTO;
import com.hospital.dto.UserRespDTO;
import com.hospital.entities.User;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserDao userDao;
	private final ModelMapper mapper;
	private final PasswordEncoder passwordEncoder;
	
	@Override
	public UserRespDTO signUp(@Valid SignupRequestDTO dto) {
		// 1. check for dup email
				if (userDao.existsByEmail(dto.getEmail()))
					throw new ApiException("Dup Email detected - User exists already!!!!");
				// 2. dto -> entity

				User entity = mapper.map(dto, User.class);
				//3 encrypt password
				entity.setPassword(passwordEncoder.encode(entity.getPassword()));
				//4. save the entity n map persistent entity -> resp dto
				return mapper.map(userDao.save(entity), UserRespDTO.class);
	}

}
