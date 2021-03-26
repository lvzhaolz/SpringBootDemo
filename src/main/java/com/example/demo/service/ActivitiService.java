package com.example.demo.service;

/**
 * @author lvzhao
 * @since 2021/3/26.
 */
public interface ActivitiService {

    void deployProcessTest();

    void queryProcessTest();

    void startProcessTest();

    void queryTask();

    void completeTaskTest();

    void queryProcessDeployment();

    void deleteDeployment();
}
