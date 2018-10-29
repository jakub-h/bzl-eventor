package cz.zbmob.dao;

import cz.zbmob.entity.Series;

import java.time.Year;
import java.util.List;

public interface SeriesDao {
	/**
	 * Create {@link Series}.
	 *
	 * @param series to create
	 */
	void create(Series series);

	/**
	 * Update {@link Series}.
	 *
	 * @param series to update
	 * @return updated series
	 */
	Series update(Series series);

	/**
	 * Delete {@link Series}.
	 *
	 * @param series to delete
	 */
	void delete(Series series);

	/**
	 * Find {@link Series} by id.
	 *
	 * @param id to find
	 * @return series with given id
	 */
	Series findById(Long id);

	/**
	 * Find {@link Series} starting in given year.
	 *
	 * @param startYear to find
	 * @return series starting in given year
	 */
	Series findByStartYear(Year startYear);

	/**
	 * Find {@link Series}s containing given string in description.
	 *
	 * @param partOfDescription to find
	 * @return series with given string in description
	 */
	List<Series> findByDescriptionPart(String partOfDescription);

	/**
	 * Find all {@link Series}s.
	 *
	 * @return all series
	 */
	List<Series> findAll();
}
