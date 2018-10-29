package cz.zbmob.dao;

import cz.zbmob.entity.Entry;
import cz.zbmob.entity.Race;
import cz.zbmob.entity.Runner;
import cz.zbmob.enums.Category;

import java.util.List;


public interface EntryDao {
	/**
	 * Create {@link Entry}.
	 *
	 * @param entry to create
	 */
	void create(Entry entry);

	/**
	 * Update {@link Entry}.
	 *
	 * @param entry to update
	 * @return updated entry
	 */
	Entry update(Entry entry);

	/**
	 * Delete {@link Entry}.
	 *
	 * @param entry to delete
	 */
	void delete(Entry entry);

	/**
	 * Find {@link Entry} by id.
	 *
	 * @param id to find
	 * @return entry with given id
	 */
	Entry findById(Long id);

	/**
	 * Find {@link Entry} by given race and runner.
	 *
	 * @param runner to find
	 * @param race ot find
	 * @return entry of given runner in given race
	 */
	Entry findByRunnerAndRace(Runner runner, Race race);

	/**
	 * Find {@link Entry} by given race and SI number.
	 *
	 * @param si to find
	 * @param race to find
	 * @return entry with given SI in given race
	 */
	Entry findBySIAndRace(Long si, Race race);

	/**
	 * Find all {@link Entry}s of given runner.
	 *
	 * @param runner to find
	 * @return all entries of given runner
	 */
	List<Entry> findByRunner(Runner runner);

	/**
	 * Find all {@link Entry}s of given race.
	 *
	 * @param race to find
	 * @return all entries of given race
	 */
	List<Entry> findByRace(Race race);

	/**
	 * Find all {@link Entry}s of given race without assigned SI.
	 *
	 * @param race to find
	 * @return all entries of given race without assigned SI
	 */
	List<Entry> findWithoutSIByRace(Race race);

	/**
	 * Find all {@link Entry}s to given category of given race.
	 *
	 * @param race to find
	 * @param category to find
	 * @return all entries to given category of given race
	 */
	List<Entry> findByRaceAndCategory(Race race, Category category);

	/**
	 * Find all {@link Entry}.
	 *
	 * @return all entries
	 */
	List<Entry> findAll();
}
