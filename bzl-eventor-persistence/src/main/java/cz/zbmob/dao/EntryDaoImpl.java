package cz.zbmob.dao;

import cz.zbmob.entity.Entry;
import cz.zbmob.entity.Race;
import cz.zbmob.entity.Runner;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Jakub Hruska <hruska.kuba@gmail.com>
 */
@Repository
public class EntryDaoImpl implements EntryDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(Entry entry) {
		em.persist(entry);
	}

	@Override
	public Entry update(Entry entry) {
		return em.merge(entry);
	}

	@Override
	public void delete(Entry entry) {
		em.remove(entry);
	}

	@Override
	public Entry findById(Long id) {
		List<Entry> foundEntries = em.createQuery("select e from Entry e where e.id = :id", Entry.class)
				.setParameter("id", id)
				.getResultList();
		return foundEntries.isEmpty() ? null : foundEntries.get(0);
	}

	@Override
	public List<Entry> findByRunner(Runner runner) {
		return em.createQuery("select e from Entry e where e.runner = :runner", Entry.class)
				.setParameter("runner", runner)
				.getResultList();
	}

	@Override
	public List<Entry> findByRace(Race race) {
		return em.createQuery("select e from Entry e where e.race = :race", Entry.class)
				.setParameter("race", race)
				.getResultList();
	}

	@Override
	public List<Entry> findAll() {
		return em.createQuery("select e from Entry e", Entry.class).getResultList();
	}
}
