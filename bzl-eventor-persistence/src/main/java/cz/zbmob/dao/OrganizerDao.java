package cz.zbmob.dao;

import cz.zbmob.entity.Organizer;
import cz.zbmob.entity.Race;

import java.util.List;

public interface OrganizerDao {
	/**
	 * Create {@link Organizer}.
	 *
	 * @param organizer to create
	 */
	void create(Organizer organizer);

	/**
	 * Update {@link Organizer}.
	 *
	 * @param organizer to update
	 * @return updated organizer
	 */
	Organizer update(Organizer organizer);

	/**
	 * Delete {@link Organizer}.
	 *
	 * @param organizer to delete
	 */
	void delete(Organizer organizer);

	/**
	 * Find {@link Organizer} by id.
	 *
	 * @param id to find
	 * @return organizer with given id
	 */
	Organizer findById(Long id);

	/**
	 * Find {@link Organizer} by given email.
	 *
	 * @param email to find
	 * @return organizer with given email.
	 */
	Organizer findByEmail(String email);

	/**
	 * Find all {@link Organizer}s with given privileges.
	 *
	 * @param privileges to find
	 * @return list of all organizers with given privileges
	 */
	List<Organizer> findByPrivileges(Character privileges);

	/**
	 * Find all {@link Organizer}s that are organizing given race.
	 *
	 * @param race to find
	 * @return all organizers organizing given race
	 */
	List<Organizer> findByOrganizedRace(Race race);

	/**
	 * Find all {@link Organizer}s.
	 *
	 * @return all organizers
	 */
	List<Organizer> findAll();
}
