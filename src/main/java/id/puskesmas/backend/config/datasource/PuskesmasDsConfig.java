package id.puskesmas.backend.config.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@PropertySource({ "classpath:application.properties" })
@EnableJpaRepositories(
        basePackages = "id.puskesmas.backend.repo",
        entityManagerFactoryRef = "puskesmasEntityManager",
        transactionManagerRef = "puskesmasTransactionManager"
)
public class PuskesmasDsConfig {
    @Autowired
    private Environment env;
    public static final String SQL_SESSION_FACTORY_NAME = "sessionPuskesmas";
    public static final String TX_MANAGER = "txPuskesmas";

    @Bean
    public LocalContainerEntityManagerFactoryBean puskesmasEntityManager() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(fifappsDataSource());
        em.setPackagesToScan(new String[] { "id.puskesmas.backend.model" });

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto",
                env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect",
                env.getProperty("hibernate.dialect"));
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean
    public DataSource fifappsDataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        //dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("datasource.puskesmas.jdbc-url"));
        dataSource.setUsername(env.getProperty("datasource.puskesmas.username"));
        dataSource.setPassword(env.getProperty("datasource.puskesmas.password"));

        return dataSource;
    }
    @Bean
    //@Primary
    public PlatformTransactionManager puskesmasTransactionManager() {

        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(puskesmasEntityManager().getObject());
        return transactionManager;
    }

}
