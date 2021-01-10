package com.example.activiti.controller;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActiviTaskController {

    @Autowired
    ProcessEngine processEngine;

    @RequestMapping("/test/task")
    public String index()
    {
        // 获取taskService对象
        TaskService taskService = processEngine.getTaskService();

        String assignee = "zhangsan";
        // 根据流程定义的key和负责人assignee查询当前用户的任务列表
        List<Task> tasks = taskService.createTaskQuery()
                .processDefinitionKey("qingjia")
                .taskAssignee(assignee)
                .list();

        for (Task task : tasks) {
            System.out.println("------------------------");
            System.out.println(" 流 程 实 例 id ： " +
                    task.getProcessInstanceId());
            System.out.println("任务id：" + task.getId());
            System.out.println("任务负责人：" + task.getAssignee());
            System.out.println("任务名称：" + task.getName());
            System.out.println("------------------------");
            // 流 程 实 例 id ： 50e0d164-503d-11eb-b609-4e06b4945b74
            // 任务id：50e4c908-503d-11eb-b609-4e06b4945b74
            // 任务负责人：zhangsan
            // 任务名称：填写请假单
        }

        return "ok";
    }

    @RequestMapping("/test/complete")
    public String completeTask()
    {
        TaskService taskService = processEngine.getTaskService();
        String taskId = "50e4c908-503d-11eb-b609-4e06b4945b74";
        taskService.complete(taskId);
        return "ok";
    }
}
