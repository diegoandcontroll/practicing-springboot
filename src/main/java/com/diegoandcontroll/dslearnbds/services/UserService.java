package com.diegoandcontroll.dslearnbds.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diegoandcontroll.dslearnbds.domain.User;
import com.diegoandcontroll.dslearnbds.dto.UserDTO;
import com.diegoandcontroll.dslearnbds.repositories.UserRepository;
import com.diegoandcontroll.dslearnbds.services.exceptions.ResourceNotFoundException;

@Service
public class UserService implements UserDetailsService {

	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	@Autowired
	private UserRepository repository;
	@Autowired
	private AuthService authService;

	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		// validação se o id for o mesmo do usuario logado.
		authService.validateSelfOrAdmin(id);
		return repository.findById(id).map(UserDTO::new)
				.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = repository.findByEmail(email);
		if (user == null) {
			logger.error("User not found: " + email);
			throw new UsernameNotFoundException("Email not found");
		}
		logger.info("User found: " + email);
		return user;
	}

}
