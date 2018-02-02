package org.proygrad.turing.persistence.config;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import java.beans.PropertyVetoException;


    @Configuration
    @EnableTransactionManagement(mode = AdviceMode.PROXY, proxyTargetClass = true)
    public class TransactionConfig implements TransactionManagementConfigurer {

        private static final Logger LOGGER = LoggerFactory.getLogger(TransactionConfig.class);

        @Autowired
        private TuringPersistenceConfig turingPersistenceConfig;

        @Bean(name = "transactionManager")
        public HibernateTransactionManager getHibernateTransactionManager() throws PropertyVetoException {
            LocalSessionFactoryBean factory = this.turingPersistenceConfig.getLocalSessionFactoryBean();
            SessionFactory sessionFactory = factory.getObject();
            return new HibernateTransactionManager(sessionFactory);
        }

        @Override
        public PlatformTransactionManager annotationDrivenTransactionManager() {
            try {
                return this.getHibernateTransactionManager();
            } catch (PropertyVetoException e) {
                LOGGER.error("Error configuring transaction event");
                throw new RuntimeException(e);
            }
        }

    }
