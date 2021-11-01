package kr.co.renzo.infrastructure.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Slf4j
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {
                "kr.co.renzo.domain.**.repository"
        },
        entityManagerFactoryRef = "renzoEntityManagerFactory",
        transactionManagerRef = "renzoTransactionManager",
        repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class
)
public class RenzoDataSourceConfig {
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlAuto;

    @Value("${spring.jpa.properties.hibernate.dialect}")
    private String dialect;

    @Value("${spring.jpa.properties.hibernate.format_sql}")
    private String formatSql;

    @Value("${spring.jpa.properties.hibernate.show_sql}")
    private String showSql;

    @Value("${spring.jpa.properties.hibernate.use_sql_comments}")
    private String useSqlComments;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource renzoDataSource() {
        return DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .build();
    }

    @Bean(name = "renzoEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean renzoEentityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(Boolean.TRUE);

        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

        entityManagerFactoryBean.setPersistenceProvider(new HibernatePersistenceProvider());
        entityManagerFactoryBean.setPackagesToScan("kr.co.renzo.domain.**.entity");
        entityManagerFactoryBean.setDataSource(renzoDataSource());
        entityManagerFactoryBean.setJpaProperties(hibernateProperties());
        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
        entityManagerFactoryBean.setPersistenceUnitName("renzoEntityManagerUnit");
        entityManagerFactoryBean.afterPropertiesSet();

        return entityManagerFactoryBean;
    }

    @Bean(name = "renzoTransactionManager")
    public PlatformTransactionManager renzoTransactionManager(
            @Qualifier("renzoEntityManagerFactory") EntityManagerFactory renzoEntityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(renzoEntityManagerFactory);

        return transactionManager;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();

        properties.setProperty("hibernate.hbm2ddl.auto", ddlAuto);
        properties.setProperty("hibernate.dialect", dialect);
        properties.setProperty("hibernate.format_sql", formatSql);
        properties.setProperty("hibernate.show_sql", showSql);
        properties.setProperty("hibernate.use_sql_comments", useSqlComments);

        return properties;
    }

}
