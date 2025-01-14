package com.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int uid;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	private boolean enabled=true;
	private String profile;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user")
	@JsonIgnore
	private Set<User_role> user_roles = new HashSet<>();

	public Set<User_role> getUser_roles() {
		// TODO Auto-generated method stub
		return user_roles;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enabled;
	}

	public int getUid() {
		// TODO Auto-generated method stub
		return uid;
	}

	public String getFirstname() {
		// TODO Auto-generated method stub
		return firstname;
	}

	public String getLastname() {
		// TODO Auto-generated method stub
		return lastname;
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}

	public String getPhone() {
		// TODO Auto-generated method stub
		return phone;
	}

	public String getProfile() {
		// TODO Auto-generated method stub
		return profile;
	}

	public void setProfile(String string) {
		// TODO Auto-generated method stub
		this.profile=string;
	}

	public void setPassword(String encode) {
		// TODO Auto-generated method stub
		this.password=encode;
	}



	public CharSequence getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	public void setUsername(String string) {
		// TODO Auto-generated method stub
		this.username=string;
	}

	public void setFirstname(String string) {
		// TODO Auto-generated method stub
		this.firstname=string;
	}

	public void setLastname(String string) {
		// TODO Auto-generated method stub
		this.lastname=string;
	}

	public void setEmail(String string) {
		// TODO Auto-generated method stub
		this.email=string;
	}

	public void setPhone(String string) {
		// TODO Auto-generated method stub
		this.phone=string;
	}




	

}
