package edu.poly.shop.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="accounts")
public class Account implements Serializable {
	@Id
	@Column(length = 30)
	private String username;
	
	@Column(nullable = false,length = 60)
	@Length(max = 60)
	private String password;
}
