package cz.zbmob.dao;

import cz.zbmob.entity.Organizer;
import cz.zbmob.entity.Race;
import cz.zbmob.entity.Series;

import java.time.LocalDate;
import java.util.List;

public interface RaceDao {
	/**
	 * Create {@link Race}.
	 *
	 * @param race to create
	 */
	void create(Race race);

	/**
	 * Update {@link Race}.
	 *
	 * @param race to update
	 * @return updated race
	 */
	Race update(Race race);

	/**
	 * Delete {@link Race}.
	 *
	 * @param race to delete
	 */
	void delete(Race race);

	/**
	 * Find {@link Race} by id.
	 *
	 * @param id to find
	 * @return Race with given id
	 */
	Race findById(Long id);

	/**
	 * Find {@link Race}s with given name
	 *
	 * @param name to find
	 * @return all races with given name
	 */
	List<Race> findByName(String name);

	/**
	 * Find {@link Race} with given date.
	 *
	 * @param date to find
	 * @return race with given date
	 */
	Race findByDate(LocalDate date);

	/**
	 * Find {@link Race}s of given series.
	 *
	 * @param series to find
	 * @return all races of given series
	 */
	List<Race> findBySeries(Series series);

	/**
	 * Find {@link Race}s organized by given organizer.
	 *
	 * @param organizer to find
	 * @return all races organized by given organizer
	 */
	List<Race> findByOrganizer(Organizer organizer);

	/**
	 * Find all {@link Race}s.
	 *
	 * @return all races
	 */
	List<Race> findAll();
}
