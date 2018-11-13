package cz.zbmob.dao;

import cz.zbmob.entity.Entry;
import cz.zbmob.entity.Race;
import cz.zbmob.entity.Runner;

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
	 * Find all {@link Entry}.
	 *
	 * @return all entries
	 */
	List<Entry> findAll();
}
