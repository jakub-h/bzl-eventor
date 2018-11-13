package cz.zbmob.dao;

import cz.zbmob.entity.Organizer;
import cz.zbmob.entity.Race;
import cz.zbmob.entity.Series;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Jakub Hruska <hruska.kuba@gmail.com>
 */
@Repository
public class RaceDaoImpl implements RaceDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(Race race) {
		em.persist(race);
	}

	@Override
	public Race update(Race race) {
		return em.merge(race);
	}

	@Override
	public void delete(Race race) {
		em.remove(race);
	}

	@Override
	public Race findById(Long id) {
		List<Race> foundRaces = em.createQuery("select r from races r where r.id = :id", Race.class)
				.setParameter("id", id)
				.getResultList();
		return foundRaces.isEmpty() ? null : foundRaces.get(0);
	}

	@Override
	public List<Race> findByName(String name) {
		return em.createQuery("select r from races r where r.name = :name", Race.class)
				.setParameter("name", name)
				.getResultList();
	}

	@Override
	public Race findByDate(LocalDate date) {
		List<Race> foundRaces = em.createQuery("select r from races r where r.date = :date", Race.class)
				.setParameter("date", date)
				.getResultList();
		return foundRaces.isEmpty() ? null : foundRaces.get(0);
	}

	@Override
	public List<Race> findBySeries(Series series) {
		return em.createQuery("select r from races r where r.series = :series", Race.class)
				.setParameter("series", series)
				.getResultList();
	}

	@Override
	public List<Race> findByOrganizer(Organizer organizer) {
		return em.createQuery("select r from races r where r.organizer = :organizer", Race.class)
				.setParameter("organizer", organizer)
				.getResultList();
	}

	@Override
	public List<Race> findAll() {
		return em.createQuery("select r from races r", Race.class).getResultList();
	}
}
