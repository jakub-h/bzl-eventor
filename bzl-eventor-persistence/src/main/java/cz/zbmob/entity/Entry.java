package cz.zbmob.entity;

import cz.zbmob.enums.Category;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Class representing an entry of a runner into a race
 *
 * @author Jakub Hruska <hruska.kuba@gmail.com>
 */
@Entity
@Table(name = "entry")
public class Entry {

	/*
	 Attributes
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "runnerId", nullable = false)
	private Runner runner;

	@ManyToOne
	@JoinColumn(name = "raceId", nullable = false)
	private Race race;

	@NotNull
	@Column(nullable = false)
	private LocalDateTime timestamp;

	@Column
	private Duration resultTime;

	@Column(unique = true)
	@Min(0)
	private Long si;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Category category;

	/*
	 Getters and setters
	 */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Runner getRunner() {
		return runner;
	}

	public void setRunner(Runner runner) {
		this.runner = runner;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public Duration getResultTime() {
		return resultTime;
	}

	public void setResultTime(Duration resultTime) {
		this.resultTime = resultTime;
	}

	public Long getSi() {
		return si;
	}

	public void setSi(Long si) {
		this.si = si;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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
		if (!(o instanceof Entry))
			return false;
		Entry other = (Entry) o;
		return Objects.equals(race, other.race) && Objects.equals(runner, other.runner);
	}

	@Override
	public int hashCode() {
		return Objects.hash(runner, race);
	}

	@Override
	public String toString() {
		return "Entry{" +
				"id=" + id +
				", runner=" + runner +
				", race=" + race +
				", timestamp=" + timestamp +
				", resultTime=" + resultTime +
				", si=" + si +
				", category=" + category +
				'}';
	}
}
