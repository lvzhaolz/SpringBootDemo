package com.example.demo;

import com.example.demo.service.ActivitiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lvzhao
 * @since 2021/3/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivitiProcessTest {

    @Autowired
    private ActivitiService activitiService;

    @Test
    public void testDeployProcess() {
        activitiService.deployProcessTest();
    }

    @Test
    public void testQueryProcess() {
        activitiService.queryProcessTest();
    }

    @Test
    public void testProcessStart() {
        activitiService.startProcessTest();
    }

    @Test
    public void testQueryTask() {
        activitiService.queryTask();
    }

    @Test
    public void testCompleteTask() {
        activitiService.completeTaskTest();
    }

    @Test
    public void testQueryProcessDeployment() {
        activitiService.queryProcessDeployment();
    }

    @Test
    public void testDeleteDeployment() {
        activitiService.deleteDeployment();
    }

}
