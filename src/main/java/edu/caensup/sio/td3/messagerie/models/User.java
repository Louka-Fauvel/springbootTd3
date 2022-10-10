package edu.caensup.sio.td3.messagerie.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NonNull
	@Column(length = 30, nullable = false)
	private String firstname;
	
	@NonNull
	@Column(length = 30, nullable = false)
	private String lastname;
	
	@NonNull
	@Column(length = 255, nullable = false)
	private String email;
	
	@NonNull
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = true)
	private boolean suspended;
	
	@JsonIgnore
	@ManyToOne
	private Organization organization;
	
}
