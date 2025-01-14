package com.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
public class User_role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int urid;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	
	@ManyToOne
	private Role role;

	public Role getRole() {
		// TODO Auto-generated method stub
		return role;
	}

	public void setUser(User user2) {
		// TODO Auto-generated method stub
		this.user=user2;
	}

	public void setRole(Role role2) {
		// TODO Auto-generated method stub
		this.role=role2;
	}

	public int getUrid() {
		// TODO Auto-generated method stub
		return urid;
	}

	public void setUrid(int urid2) {
		// TODO Auto-generated method stub
		this.urid=urid2;
	}

	
	
	

}
