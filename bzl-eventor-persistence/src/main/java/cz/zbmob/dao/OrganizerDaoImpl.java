package cz.zbmob.dao;

import cz.zbmob.entity.Organizer;
import cz.zbmob.entity.Race;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Jakub Hruska <hruska.kuba@gmail.com>
 */
@Repository
public class OrganizerDaoImpl implements OrganizerDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(Organizer organizer) {
		em.persist(organizer);
	}

	@Override
	public Organizer update(Organizer organizer) {
		return em.merge(organizer);
	}

	@Override
	public void delete(Organizer organizer) {
		em.remove(organizer);
	}

	@Override
	public Organizer findById(Long id) {
		List<Organizer> foundOrganizers = em.createQuery("select o from Organizer o where o.id = :id",
				Organizer.class)
				.setParameter("id", id)
				.getResultList();
		return foundOrganizers.isEmpty() ? null : foundOrganizers.get(0);
	}

	@Override
	public Organizer findByEmail(String email) {
		List<Organizer> foundOrganizers = em.createQuery("select o from Organizer o where lower(o.email) = :email",
				Organizer.class)
				.setParameter("email", email)
				.getResultList();
		return foundOrganizers.isEmpty() ? null : foundOrganizers.get(0);
	}

	@Override
	public List<Organizer> findByPrivileges(Character privileges) {
		return em.createQuery("select o from Organizer o where lower(o.privileges) = :privileges", Organizer.class)
				.setParameter("privileges", privileges)
				.getResultList();
	}

	@Override
	public List<Organizer> findAll() {
		return em.createQuery("select o from Organizer o", Organizer.class).getResultList();
	}
}
