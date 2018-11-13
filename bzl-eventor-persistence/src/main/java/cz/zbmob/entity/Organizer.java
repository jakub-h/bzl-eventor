package cz.zbmob.entity;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Class representing an organizer (one person)
 */
@Entity
@Table(name = "organizers")
public class Organizer {

	/*
	 Attributes
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(nullable = false, unique = true)
	@Email
	private String email;

	@NotNull
	@Column(nullable = false)
	private Character privileges;

	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(
			name = "isOrganizedBy",
			joinColumns = {@JoinColumn(name = "organizerId")},
			inverseJoinColumns = {@JoinColumn(name = "raceId")}
	)
	private Set<Race> organizedRaces = new HashSet<>();

	/*
	 Getters and setters
	 */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Character getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Character priviledges) {
		this.privileges = priviledges;
	}

	public Set<Race> getOrganizedRaces() {
		return organizedRaces;
	}

	public void setOrganizedRaces(Set<Race> organizedRaces) {
		this.organizedRaces = organizedRaces;
	}

	/*
	 equals, hashCode and toString
	 */

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (!(o instanceof Organizer))
			return false;
		Organizer organizer = (Organizer) o;
		return Objects.equals(email, organizer.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(email);
	}

	@Override
	public String toString() {
		return "Organizer{" +
				"id=" + id +
				", email='" + email + '\'' +
				", privileges=" + privileges +
				'}';
	}
}
