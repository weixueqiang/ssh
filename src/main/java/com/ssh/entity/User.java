package com.ssh.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="user")
public class User implements Serializable{

	/**
	 * @date 2018年5月11日 下午5:48:19
	 * @author 魏雪强
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer id;
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="salt")
	private String salt;
	
}
