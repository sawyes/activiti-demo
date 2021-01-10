package com.example.activiti.controller;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivitiStartIntanceController {

    @Autowired
    ProcessEngine processEngine;

    @RequestMapping("/test/intance")
    public String index(){
        // 获取RunTimeService
        RuntimeService runtimeService =
                processEngine.getRuntimeService();

        // 根据流程定义key启动流程
        ProcessInstance processInstance = runtimeService
                .startProcessInstanceByKey("qingjia");

        System.out.println(" 流程定义 id ： " +
                processInstance.getProcessDefinitionId());
        System.out.println("流程实例id：" + processInstance.getId());
        System.out.println(" 当前活动 Id ： " +
                processInstance.getActivityId());

        return "hello";
    }
}
