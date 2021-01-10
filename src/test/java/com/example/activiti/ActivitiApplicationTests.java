package com.example.activiti;

import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class ActivitiApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Test
    void contextLoads() {
        ProcessEngineConfiguration processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResourceDefault();
        
        processEngine.buildProcessEngine();

    }

}
