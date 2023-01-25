package com.fauv.authenticator.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "user", schema = "authentication")
public class User implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "vw_id")
	private String vwId;
	@Column(name = "password")
	private String password;
	@Column(name = "active")
	private boolean active;
	@Column(name = "access_token")
	private String accessToken;
	@ManyToMany
	@JoinTable(
		name = "user_role",
		joinColumns= @JoinColumn(name = "vw_id"),
		inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	private Set<Role> roles = new HashSet<Role>();
	
	public String getVwId() {
		return vwId;
	}
	
	public void setVwId(String vwId) {
		this.vwId = vwId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public String getAccessToken() {
		return accessToken;
	}
	
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.getRoles();
	}

	@Override
	public String getUsername() {
		return this.vwId;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		return this.isActive();
	}

	@Override
	public int hashCode() {
		return Objects.hash(accessToken, active, password, roles, vwId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(accessToken, other.accessToken) && active == other.active
				&& Objects.equals(password, other.password) && Objects.equals(roles, other.roles)
				&& Objects.equals(vwId, other.vwId);
	}

	@Override
	public String toString() {
		return "User [vwId=" + vwId + ", password=" + password + ", active=" + active + ", accessToken=" + accessToken
				+ ", roles=" + roles + "]";
	}
	
}
