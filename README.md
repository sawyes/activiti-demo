# 工程简介

Activiti学习Demo

1. Springboot集成Activiti7
2. IDE安装ActiBPM插件
3. 设计请假流程
4. 初始化流程表
5. 部署请假流程定义
6. 启动一个请假流程实例
7. 按用户查询当流程任务列表
8. 处理任务

## 初始化流程表

启动项目，`会自动生成表`

## 部署请假流程定义

ActivitiDeployController@index

* act_re_deployment 部署流程名称
* act_re_procdef 部署流程定义
* act_ge_bytearray 部署流程资源文件

## 启动一个请假流程实例

ActivitiStartIntanceController@index

前提条件: 已完成流程定义的部署工作

受影响的表

* act_hi_actinst 已完成的活动信息, 包含历史已执行,和一条正在执行, 未执行的数据不在其中
* act_hi_identitylink 相关流程负责人 
* act_hi_procinst 流程实例信息
* act_hi_taskinst '历史任务实例表

* act_ru_execution 运行时流程执行实例表
* act_ru_identitylink 相关流程负责人
* act_ru_task 任务, 当前需要完成的流程

## 按用户查询当流程任务列表
ActiviTaskController@index
查询结果
```
流 程 实 例 id ： 50e0d164-503d-11eb-b609-4e06b4945b74
任务id：50e4c908-503d-11eb-b609-4e06b4945b74
任务负责人：zhangsan
任务名称：填写请假单
```
## 处理任务

ActiviTaskController@completeTask

SQL操作步骤
* ACT_HI_TASKINST 插入下一个节点流程的信息
* ACT_HI_ACTINST  插入下一个节点流程的信息
* ACT_HI_IDENTITYLINK  插入下一个节点流程的处理人信息
* ACT_RU_TASK     插入下一个节点流程的信息
* ACT_RU_IDENTITYLINK 插入下一个节点流程的处理人信息
* ACT_HI_TASKINST 更新当前节点结束时间, 处理人, 耗时多少秒, 删除利用信息
* ACT_RU_TASK     物理删除当前节点处理信息(一个流程只保留最新信息)

