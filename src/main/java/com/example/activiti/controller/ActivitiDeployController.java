package com.example.activiti.controller;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ActivitiDeployController {

    @Resource
    ProcessEngine processEngine;

    /**
     * 启动一个流程实例
     * @return
     */
    @RequestMapping("/test/deploy")
    public String index(){

        // 手动获取默认实例
        // ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 获得repositoryService实例
        RepositoryService repositoryService = processEngine.getRepositoryService();
        // 进行部署
        Deployment deploy = repositoryService.createDeployment()
                .addClasspathResource("diagram/qingjia.bpmn")
                .addClasspathResource("diagram/qingjia.png")
                .name("请假申请单流程")
                .deploy();

        System.out.println("流程getName===>" + deploy.getName());
        System.out.println("流程getId===>" + deploy.getId());

        return "ok";
    }

}
