package org.yakimovdenis.webserver.database;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.yakimovdenis.webserver.WebServerApplicationTests;

@ContextConfiguration(classes = {TestJpaConfig.class})
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
public abstract class AbstractWebDatabaseTest extends WebServerApplicationTests {
    protected final String SEPARATOR = "**********************************************************";
}
