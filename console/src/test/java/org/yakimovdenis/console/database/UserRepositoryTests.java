package org.yakimovdenis.console.database;

import jshop.model.GrantedAuthorityEntity;
import jshop.model.UserEntity;
import jshop.repositories.UserDao;
import jshop.services.UserServiceImpl;
import jshop.storage.UserCache;
import net.sf.ehcache.CacheManager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.PlatformTransactionManager;
import org.yakimovdenis.console.service.StatisticsService;


import java.util.*;

import static org.junit.Assert.*;


public class UserRepositoryTests extends AbstractDatabaseTest {

    @Autowired
    private StatisticsService statisticsService;


}