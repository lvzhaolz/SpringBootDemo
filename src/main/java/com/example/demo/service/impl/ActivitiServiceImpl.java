package com.example.demo.service.impl;

import com.example.demo.service.ActivitiService;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentQuery;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lvzhao
 * @since 2021/3/26.
 */
@Service
@Slf4j
public class ActivitiServiceImpl implements ActivitiService {

    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    @Override
    public void deployProcessTest() {
        repositoryService.createDeployment()
                .addClasspathResource("process/test.bpmn")
                .name("test")
                .deploy();
    }

    @Override
    public void queryProcessTest() {
        List<Deployment> deploymentList = repositoryService.createDeploymentQuery().deploymentName("test").list();
        List<ProcessDefinition> processDefinitionList = repositoryService.createProcessDefinitionQuery().list();

        log.info("deployment - {}", deploymentList);
        log.info("process definition - {}", processDefinitionList);
    }

    @Override
    public void startProcessTest() {
        runtimeService.startProcessInstanceById("test:1:2503");
        //添加业务主键
//        runtimeService.startProcessInstanceById("test:1:2503", "testBusinessKey");
    }

    @Override
    public void queryTask() {
        List<Task> taskList = taskService.createTaskQuery().list();
        log.info("task - {}", taskList);
    }

    @Override
    public void completeTaskTest() {
        taskService.complete("5005");
    }

    @Override
    public void queryProcessDeployment() {
        DeploymentQuery query = repositoryService.createDeploymentQuery();
        List<Deployment> deploymentList = query.deploymentName("test").list();

        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        List<ProcessDefinition> processDefinitionList = processDefinitionQuery.deploymentId(deploymentList.get(0).getId()).list();

        log.info("query process deployment - {}", deploymentList);
        log.info("query process deployment - {}", processDefinitionList);

//        ProcessDefinition df = list1.get(0);
//        String saveResourceDir = "C:\\Users\\newtab\\Desktop\\activitilogs\\";
//        InputStream is = repositoryService.getResourceAsStream(df.getDeploymentId(), df.getResourceName());
//        InputStream dis = repositoryService.getResourceAsStream(df.getDeploymentId(), df.getDiagramResourceName());
//        OutputStream os = new FileOutputStream(saveResourceDir + df.getResourceName());
//        FileOutputStream dos = new FileOutputStream(saveResourceDir + df.getDiagramResourceName());
//        IOUtils.copy(is,os);
//        IOUtils.copy(dis,dos);
//
//        os.close();
//        dos.close();
//        is.close();
//        dis.close();
    }

    @Override
    public void deleteDeployment() {
        Deployment deployment = repositoryService.createDeploymentQuery().deploymentName("test").list().stream().findFirst().get();
        repositoryService.deleteDeployment(deployment.getId());
    }

}
