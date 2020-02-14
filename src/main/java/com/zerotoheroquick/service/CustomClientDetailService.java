package com.zerotoheroquick.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import com.zerotoheroquick.model.Client;
import com.zerotoheroquick.repo.ClientRepo;

@Service
public class CustomClientDetailService implements ClientDetailsService {

	@Autowired
	private ClientRepo clientRepo;
	
	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		Optional<Client> clientOptional = clientRepo.findById(clientId);
		if(clientOptional.isPresent()) {
			
			BaseClientDetails baseClientDetails = new BaseClientDetails();
			baseClientDetails.setClientId(clientOptional.get().getClientId());
			baseClientDetails.setClientSecret(clientOptional.get().getClientSecret());
			baseClientDetails.setAccessTokenValiditySeconds(clientOptional.get().getAccessTokenValidity());
			baseClientDetails.setAuthorizedGrantTypes(clientOptional.get().getAuthorizedGrantTypes());
			baseClientDetails.setScope(clientOptional.get().getScope());
			
			return baseClientDetails;
		}
			throw new ClientRegistrationException("Client not found");
	}

}
