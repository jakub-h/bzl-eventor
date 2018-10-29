package cz.zbmob.dao;

import cz.zbmob.entity.Runner;

import java.time.Year;
import java.util.List;

public interface RunnerDao {
	/**
	 * Create {@link Runner}.
	 *
	 * @param runner to create
	 */
	void create(Runner runner);

	/**
	 * Update {@link Runner}.
	 *
	 * @param runner to update
	 * @return updated runner
	 */
	Runner update(Runner runner);

	/**
	 * Delete {@link Runner}.
	 *
	 * @param runner to delete
	 */
	void delete(Runner runner);

	/**
	 * Find {@link Runner} by id.
	 *
	 * @param id to find
	 * @return runner with given id.
	 */
	Runner findById(Long id);

	/**
	 * Find {@link Runner}s with given email.
	 *
	 * @param email to find
	 * @return runner with given email
	 */
	List<Runner> findByEmail(String email);

	/**
	 * Find {@link Runner}s with given string in one of names.
	 *
	 * @param namePart to find
	 * @return Runners whose names contain given string
	 */
	List<Runner> findByNamePart(String namePart);

	/**
	 * Find {@link Runner} with given SI.
	 *
	 * @param si to find
	 * @return runner with given si
	 */
	Runner findBySI(Long si);

	/**
	 * Find {@link Runner} with given registration.
	 *
	 * @param registration to find
	 * @return runner with given registration
	 */
	Runner findByRegistration(String registration);

	/**
	 * Find all {@link Runner}s.
	 *
	 * @return all runners
	 */
	List<Runner> findAll();
}
