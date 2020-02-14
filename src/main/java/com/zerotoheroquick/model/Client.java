package com.zerotoheroquick.model;

import java.io.Serializable;
import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@DynamoDBTable(tableName = "AUTH_SERVER_CLIENT")
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@DynamoDBHashKey
	private String clientId;

	private String clientSecret;
	private String webServerRedirectUri;
	private List<String> scope;
	private int accessTokenValidity;
	private String refreshTokenValidity;
	private String resourceIds;
	private List<String> authorizedGrantTypes;
	private String authorities;
	private String additionalInformation;
	private String autoapprove;
	
	private String permission;
	private String role;
}
