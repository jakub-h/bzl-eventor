package cz.zbmob.dao;

import cz.zbmob.entity.Series;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.Year;
import java.util.List;

/**
 * @author Jakub Hruska <hruska.kuba@gmail.com>
 */
@Repository
public class SeriesDaoImpl implements SeriesDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(Series series) {
		em.persist(series);
	}

	@Override
	public Series update(Series series) {
		return em.merge(series);
	}

	@Override
	public void delete(Series series) {
		em.remove(series);
	}

	@Override
	public Series findById(Long id) {
		return em.find(Series.class, id);
	}

	@Override
	public Series findByStartYear(Year startYear) {
		List<Series> foundSeries = em.createQuery("select s from series s where s.startYear = :startYear",
				Series.class)
				.setMaxResults(1)
				.setParameter("startYear", startYear)
				.getResultList();
		return foundSeries.isEmpty() ? null : foundSeries.get(0);
	}

	@Override
	public List<Series> findByDescriptionPart(String partOfDescription) {
		return em.createQuery("select s from series s where lower(s.description) like :part",
				Series.class)
				.setParameter("part", "%" + partOfDescription + "%")
				.getResultList();
	}

	@Override
	public List<Series> findAll() {
		return em.createQuery("select s from series s", Series.class).getResultList();
	}
}
