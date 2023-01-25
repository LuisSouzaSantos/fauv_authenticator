package com.fauv.authenticator.entity;

import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Request {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String vwId;
	private String accessTokenUsed;
	private boolean active;
	private ZonedDateTime date;
	private String requestUrl;
	private String remoteAddress;
	private String serverMessage;
	private String type;
	private boolean success;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVwId() {
		return vwId;
	}
	public void setVwId(String vwId) {
		this.vwId = vwId;
	}
	public String getAccessTokenUsed() {
		return accessTokenUsed;
	}
	public void setAccessTokenUsed(String accessTokenUsed) {
		this.accessTokenUsed = accessTokenUsed;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public ZonedDateTime getDate() {
		return date;
	}
	public void setDate(ZonedDateTime date) {
		this.date = date;
	}
	public String getRequestUrl() {
		return requestUrl;
	}
	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}
	public String getRemoteAddress() {
		return remoteAddress;
	}
	public void setRemoteAddress(String remoteAddress) {
		this.remoteAddress = remoteAddress;
	}
	public String getServerMessage() {
		return serverMessage;
	}
	public void setServerMessage(String serverMessage) {
		this.serverMessage = serverMessage;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
}
