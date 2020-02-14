package com.zerotoheroquick.repo;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.socialsignin.spring.data.dynamodb.repository.EnableScanCount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


import com.zerotoheroquick.model.User;
import com.zerotoheroquick.model.UserPK;

@EnableScan
@EnableScanCount
public interface UserRepo extends PagingAndSortingRepository<User, UserPK> {
	
	Page<User> findByEmail(String email, Pageable pageable);
	Page<User> findByUsername(String username, Pageable pageable);
}
