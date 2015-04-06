package com.ravijag.restexample.REST.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(MongoDBConfig.class)
@ComponentScan("com.emc.ETAPPS.REST")
public class RootApplicationConfig {
}
