package edu.caensup.sio.td3.messagerie.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor()
@RequiredArgsConstructor()
@Entity
public class Group {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NonNull
	@Column(length = 40, nullable = false)
	private String name;

	@NonNull
	@Column(length = 40, nullable = false)
	private String email;

	@NonNull
	@Column(length = 40, nullable = false)
	private String aliases;

	@ManyToMany()
	private List<User> users;

	@ManyToOne
	private Organization organization;
	
}
