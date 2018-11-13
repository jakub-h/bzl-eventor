package cz.zbmob.entity;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Year;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Class representing a runner (competitor).
 *
 * @author Jakub Hruska <hruska.kuba@gmail.com>
 */
@Entity
@Table(name = "runners")
public class Runner {

	/*
	 * Attributes
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 1, max = 30)
	@Column(nullable = false)
	private String firstName;

	@NotNull
	@Size(min = 1, max = 30)
	@Column(nullable = false)
	private String lastName;

	@NotNull
	@Email
	@Column(nullable = false)
	private String email;

	@Min(0)
	@Column(unique = true)
	private Long si;

	@NotNull
	private Year yearOfBirth;

	@Column(unique = true)
	@Size(min = 7, max = 7)
	private String registration;

	@OneToMany(mappedBy = "runner")
	private Set<Entry> entries = new HashSet<>();

	/*
	 * Getters and setters
	 */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getSi() {
		return si;
	}

	public void setSi(Long si) {
		this.si = si;
	}

	public Year getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(Year yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public Set<Entry> getEntries() {
		return entries;
	}

	public void setEntries(Set<Entry> entries) {
		this.entries = entries;
	}

	/*
	 * Equals, hashCode and toString
	 */

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (!(o instanceof Runner))
			return false;
		Runner other = (Runner) o;
		if (registration != null) {
			if (other.registration != null)
				return Objects.equals(registration, other.registration);
			return false;
		}
		if (!Objects.equals(firstName, other.firstName))
			return false;
		if (!Objects.equals(lastName, other.lastName))
			return false;
		if (!Objects.equals(email, other.email))
			return false;
		return Objects.equals(yearOfBirth, other.yearOfBirth);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, email, yearOfBirth, registration);
	}

	@Override
	public String toString() {
		return "Runner{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", si=" + si +
				", yearOfBirth=" + yearOfBirth +
				", registration='" + registration + '\'' +
				'}';
	}
}
