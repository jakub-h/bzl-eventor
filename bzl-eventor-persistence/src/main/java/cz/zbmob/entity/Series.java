package cz.zbmob.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Year;
import java.util.*;

/**
 * Class representing one Series (year) of races
 *
 * @author Jakub Hruska <hruska.kuba@gmail.com>
 */
@Entity
@Table(name = "series")
public class Series {

	/*
	 Attributes
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(nullable = false, unique = true)
	private Year startYear;

	@NotNull
	@Column(nullable = false)
	@Size(min = 4, max = 50)
	private String description;

	@OneToMany(mappedBy = "series")
	private List<Race> races = new ArrayList<>();

	/*
	 Getters and setters
	 */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Year getStartYear() {
		return startYear;
	}

	public void setStartYear(Year startYear) {
		this.startYear = startYear;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Race> getRaces() {
		return races;
	}

	public void setRaces(List<Race> races) {
		this.races = races;
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
		if (!(o instanceof Series))
			return false;
		Series series = (Series) o;
		return Objects.equals(startYear, series.startYear);
	}

	@Override
	public int hashCode() {
		return Objects.hash(startYear);
	}

	@Override
	public String toString() {
		return "Series{" +
				"id=" + id +
				", startYear=" + startYear +
				", description='" + description + '\'' +
				", races=" + races +
				'}';
	}
}
