package com.mears.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

//import com.mears.repositories.RepositoryPackage;
//import com.mears.template.TemplatePackage;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;

@Configuration
//@EnableMongoRepositories(basePackageClasses=RepositoryPackage.class)
//@ComponentScan(basePackageClasses=TemplatePackage.class)
public class DatasourceConfig extends AbstractMongoConfiguration {

    // --- mongodb config

    @Override
    protected String getDatabaseName() {
        return "mearsdriverdb";
    }

    @Override
    @Bean
    public MongoClient mongo() throws Exception {
        MongoClient client = new MongoClient("mongo-host");
        client.setWriteConcern(WriteConcern.SAFE);
        return client;
    }

    @Override
    protected String getMappingBasePackage() {
        return "com.mears.entities";
    }

    // ---------------------------------------------------- MongoTemplate

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), getDatabaseName());
    }
}
