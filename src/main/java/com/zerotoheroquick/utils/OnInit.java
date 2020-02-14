package com.zerotoheroquick.utils;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.zerotoheroquick.model.Client;
import com.zerotoheroquick.model.User;
import com.zerotoheroquick.model.UserPK;
import com.zerotoheroquick.repo.ClientRepo;
import com.zerotoheroquick.repo.UserRepo;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OnInit {
	private final UserRepo userRepo;
	private final ClientRepo clientRepo;
	private final PasswordEncoder passwordEncoder;

	@PostConstruct
	public void setUp() {
		userRepo.save(User.builder()
				.userPK(UserPK.builder().email("email.com").username("kush").build())
				.password(passwordEncoder.encode("pass"))
				.enabled(true)
				.credentialsNonExpired(true)
				.accountNonLocked(true)
				.accountNonExpired(true)
				.roles(Arrays.asList("ADMIN"))
				.build());

		clientRepo.save(Client.builder()
				.clientId("app1")
				.clientSecret(passwordEncoder.encode("pass"))
				.accessTokenValidity(3600)
				.authorizedGrantTypes(Arrays.asList("refresh_token","authorization_code","password","client_credentials"))
				.scope(Arrays.asList("READ","WRITE"))
				.build());
		
		System.out.println(userRepo.findByEmail("email.com", PageRequest.of(0, 1)).getContent());
		System.out.println(userRepo.findByUsername("kush", PageRequest.of(0, 1)));
	}
}
