package cz.zbmob.dao;

import cz.zbmob.entity.Runner;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Jakub Hruska <hruska.kuba@gmail.com>
 */
@Repository
public class RunnerDaoImpl implements RunnerDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(Runner runner) {
		em.persist(runner);
	}

	@Override
	public Runner update(Runner runner) {
		return em.merge(runner);
	}

	@Override
	public void delete(Runner runner) {
		em.remove(runner);
	}

	@Override
	public Runner findById(Long id) {
		return em.find(Runner.class, id);
	}

	@Override
	public List<Runner> findByEmail(String email) {
		return em.createQuery("select r from runners r where lower(r.email) = :email", Runner.class)
				.setParameter("email", email)
				.getResultList();
	}

	@Override
	public List<Runner> findByNamePart(String namePart) {
		return em.createQuery("select r from runners r where lower(r.firstName) like :namePart " +
														"or lower(r.lastName) like :namePart",
				Runner.class)
				.setParameter("namePart", "%" + namePart + "%")
				.getResultList();
	}

	@Override
	public Runner findBySI(Long si) {
		List<Runner> foundRunners = em.createQuery("select r from runners r where r.si = :si", Runner.class)
				.setParameter("si", si)
				.getResultList();
		return foundRunners.isEmpty() ? null : foundRunners.get(0);
	}

	@Override
	public Runner findByRegistration(String registration) {
		List<Runner> foundRunners = em.createQuery("select r from runners r where lower(r.registration) = :registration", Runner.class)
				.setParameter("registration", registration)
				.getResultList();
		return foundRunners.isEmpty() ? null : foundRunners.get(0);
	}

	@Override
	public List<Runner> findAll() {
		return em.createQuery("select r from runners r", Runner.class).getResultList();
	}
}
