package com.zerotoheroquick.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.zerotoheroquick.model.User;
import com.zerotoheroquick.repo.UserRepo;

@Component
public class UserDetailsServiceImpl implements UserDetailsService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Page<User> userpage = userRepo.findByEmail(email, PageRequest.of(0, 1));
		User user;
		if (userpage.getContent() == null) {
			throw new UsernameNotFoundException("Invalid emai/username" + email);
		} else {
			user = userpage.getContent().get(0);

		}

		return new UserDetails() {

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isEnabled() {
				return user.isEnabled();
			}

			@Override
			public boolean isCredentialsNonExpired() {
				return user.isCredentialsNonExpired();
			}

			@Override
			public boolean isAccountNonLocked() {
				return user.isAccountNonLocked();
			}

			@Override
			public boolean isAccountNonExpired() {

				return user.isCredentialsNonExpired();
			}

			@Override
			public String getUsername() {
				return user.getEmail();
			}

			@Override
			public String getPassword() {
				return user.getPassword();
			}

			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
				user.getRoles().forEach(role -> grantedAuthorities.add(new SimpleGrantedAuthority(role)));
				return grantedAuthorities;
			}
		};
	}

}
