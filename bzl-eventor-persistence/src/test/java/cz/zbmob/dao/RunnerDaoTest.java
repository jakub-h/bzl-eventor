package cz.zbmob.dao;

import cz.zbmob.config.PersistenceConfiguration;
import cz.zbmob.entity.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.transaction.Transactional;
import java.time.Year;

import static org.assertj.core.api.Assertions.*;

/**
 * @author Jakub Hruska <hruska.kuba@gmail.com>
 */
@ContextConfiguration(classes = PersistenceConfiguration.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class RunnerDaoTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private RunnerDao runnerDao;

	private Runner runner;

	@BeforeMethod
	public void setUp() {
		runner = new Runner();
		runner.setFirstName("Dušan");
		runner.setLastName("Popelnice");
		runner.setEmail("sezeruvse@gmail.com");
		runner.setSi(8660400L);
		runner.setYearOfBirth(Year.of(1997));
		runner.setRegistration("ZBM9701");
	}

	@Test
	public void createRunner() {
		runnerDao.create(runner);
		assertThat(runnerDao.findAll().size()).isEqualTo(1);
		assertThat(runnerDao.findById(runner.getId())).isEqualToComparingFieldByField(runner);
	}
}
