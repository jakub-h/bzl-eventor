package cz.zbmob.dao;

import cz.zbmob.config.PersistenceConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import javax.transaction.Transactional;

/**
 * @author Jakub Hruska <hruska.kuba@gmail.com>
 */
@ContextConfiguration(classes = PersistenceConfiguration.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class EntryDaoTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private EntryDao entryDao;

	@Autowired
	private RunnerDao runnerDao;
}
