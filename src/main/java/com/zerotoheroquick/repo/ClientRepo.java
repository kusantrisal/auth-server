package com.zerotoheroquick.repo;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.socialsignin.spring.data.dynamodb.repository.EnableScanCount;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.zerotoheroquick.model.Client;

@EnableScan
@EnableScanCount
public interface ClientRepo extends PagingAndSortingRepository<Client, String> {

}
