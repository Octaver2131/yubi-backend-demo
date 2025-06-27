# 欧可可智能分析平台

> 作者：[Octaver](https://github.com/Octaver2131)
> 指导：[程序员鱼皮](https://github.com/liyupi)

## 项目简介 

欧可可智能分析平台是一个基于Spring Boot构建的智能分析系统，集成了自然语言处理、数据检索与分析等核心能力，提供高效的数据处理与智能分析解决方案。平台采用模块化设计，支持快速扩展与定制，适用于各类数据分析与智能应用场景。

## 核心亮点 

- **智能分析能力**：集成DeepSeek SDK，提供自然语言处理与智能分析功能
- **高性能架构**：采用Redis+Redisson限流、RabbitMQ消息队列实现高并发处理

## 技术架构 

### 主流框架 & 特性

- **核心框架**：Spring Boot 2.7.x、Spring MVC
- **数据访问**：MyBatis + MyBatis Plus（含分页插件）
- **企业级特性**：Spring AOP切面编程、Spring Scheduler定时任务、事务管理
- **开发辅助**：Spring Boot DevTools、项目处理器

### 技术选型

| 分类         | 技术选型                | 说明                          |
|--------------|-------------------------|-------------------------------|
| **缓存/限流** | Redis + Redisson        | 分布式缓存与限流解决方案      |
| **消息队列** | RabbitMQ                | 异步消息处理                  |
| **AI能力**   | DeepSeek SDK            | 自然语言处理与智能分析能力    |
| **异步处理** | JDK线程池               | 任务异步化处理                |

### 数据存储方案

- **主数据库**：MySQL - 存储核心业务数据
- **缓存数据库**：Redis - 存储热点数据与缓存

### 工具类库

- **表格处理**：Easy Excel
- **通用工具**：Hutool
- **JSON处理**：Gson
- **基础工具**：Apache Commons Lang3
- **代码简化**：Lombok

## 核心功能模块 

### 系统管理

- **权限控制**：自定义权限注解 + 全局校验机制
- **日志系统**：全局请求响应拦截器，记录完整操作日志

### 智能分析

- **DeepSeek集成**：通过SDK接入自然语言处理能力
- **数据处理**：支持自定义分析任务与定时处理

## 系统特性 

- **异常处理**：全局异常处理器 + 自定义错误码体系
- **响应封装**：统一的API响应格式设计
- **接口文档**：Swagger + Knife4j自动生成交互式文档
- **跨域支持**：全局跨域处理解决方案
- **精度控制**：长整数丢失精度解决方案
- **多环境支持**：完善的多环境配置管理

## 快速开始 

### 环境要求

- JDK 1.8+
- MySQL 5.7+
- Redis 5.0+
- RabbitMQ 3.8+（可选，若使用消息队列功能）

### 启动步骤

**克隆项目**
```bash
  git clone https://github.com/Octaver2131/yubi-backend-demo.git
```

**访问接口文档**
   启动后访问：`http://localhost:8101/api/doc.html`

## 项目结构

```
yubi-backend-demo/
├── src/
│   ├── main/
│   │   ├── java/com/yupi/springbootinit/
│   │   │   ├── annotation/             # 自定义注解
│   │   │   ├── aop/                    # 切面编程
│   │   │   ├── api/                    # 第三方API调用
│   │   │   ├── bizmq/                  # 消息队列相关
│   │   │   ├── common/                 # 通用类
│   │   │   ├── config/                 # 配置类
│   │   │   ├── constant/               # 常量定义
│   │   │   ├── controller/             # 控制器
│   │   │   ├── esdao/                  # Elasticsearch数据访问
│   │   │   ├── exception/              # 异常处理
│   │   │   ├── job/                    # 定时任务
│   │   │   ├── manager/                # 业务管理层
│   │   │   ├── mapper/                 # MyBatis Mapper接口
│   │   │   ├── model/                  # 数据模型
│   │   │   ├── mq/                     # 消息队列实现
│   │   │   ├── service/                # 服务层
│   │   │   ├── utils/                  # 工具类
│   │   │   └── MainApplication.java    # 启动类
│   │   └── resources/
│   │       ├── mapper/                 # MyBatis映射文件
│   │       ├── META-INF/               # 元数据
│   │       ├── application.yml         # 主配置文件
│   │       ├── application-prod.yml    # 生产环境配置
│   │       ├── application-test.yml    # 测试环境配置
│   │       └── sql/                    # SQL脚本
│   └── test/                           # 测试代码
├── pom.xml                             # Maven配置
├── README.md                           # 项目说明
└── sql/                                # 数据库脚本
```


## 版本说明 

- 当前版本：V 1.0.0


