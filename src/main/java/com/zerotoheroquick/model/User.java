package com.zerotoheroquick.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
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
@DynamoDBTable(tableName = "AUTH_SERVER_USER")
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private UserPK userPK;
	private String password;

	private boolean enabled;
	private boolean accountNonExpired;
	private boolean credentialsNonExpired;
	private boolean accountNonLocked;
	private List<String> roles;
	
	@DynamoDBHashKey(attributeName = "email")
	public String getEmail() {
		return userPK != null ? userPK.getEmail() : null;
	}

	public void setUserName(String userName) {
		if (userPK == null) {
			userPK = new UserPK();
		}
		userPK.setEmail(userName);
	}

	public void setEmail(String email) {
		if (userPK == null) {
			userPK = new UserPK();
		}
		userPK.setEmail(email);
	}

	@DynamoDBRangeKey(attributeName = "username")
	public String getUsername() {
		return userPK != null ? userPK.getUsername() : null;
	}

	public void setUsername(String username) {
		if (userPK == null) {
			userPK = new UserPK();
		}
		userPK.setUsername(username);
	}

}
