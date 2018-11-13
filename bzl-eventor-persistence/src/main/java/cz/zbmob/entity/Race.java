package cz.zbmob.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Class representing a race (event).
 */
@Entity
@Table(name = "races")
public class Race {

	/*
	 Attributes
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(nullable = false)
	@Size(min = 5, max = 30)
	private String name;

	@NotNull
	@Column(nullable = false, unique = true)
	private LocalDate date;

	@NotNull
	@Column(nullable = false)
	private LocalDateTime entriesDeadline;

	@NotNull
	@Column(nullable = false)
	private String pathToDescription;

	@ManyToOne
	@JoinColumn(name = "seriesId", nullable = false)
	private Series series;

	@OneToMany(mappedBy = "race")
	private Set<Entry> entries = new HashSet<>();

	@ManyToMany(mappedBy = "organizedRaces")
	private Set<Organizer> organizers = new HashSet<>();

	/*
	 Getters and setters
	 */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalDateTime getEntriesDeadline() {
		return entriesDeadline;
	}

	public void setEntriesDeadline(LocalDateTime entriesDeadline) {
		this.entriesDeadline = entriesDeadline;
	}

	public String getPathToDescription() {
		return pathToDescription;
	}

	public void setPathToDescription(String pathToDescription) {
		this.pathToDescription = pathToDescription;
	}

	public Series getSeries() {
		return series;
	}

	public void setSeries(Series series) {
		this.series = series;
	}

	public Set<Entry> getEntries() {
		return entries;
	}

	public void setEntries(Set<Entry> entries) {
		this.entries = entries;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Organizer> getOrganizers() {
		return organizers;
	}

	public void setOrganizers(Set<Organizer> organizers) {
		this.organizers = organizers;
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
		if (!(o instanceof Race))
			return false;
		Race race = (Race) o;
		return Objects.equals(date, race.date);
	}

	@Override
	public int hashCode() {
		return Objects.hash(date);
	}
}
