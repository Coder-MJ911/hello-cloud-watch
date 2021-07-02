*This is cloud watch learning repo*

*hello cloud watch*

work flow:

How to deploy a stack:
```shell
brew install serverless
```

```shell
saml2aws login --profile tw-aws-beach
```

```shell
sls deploy (default config file: serverless.yml)
sls deploy -c BACKUPServerless.yml
```


```html
Basic
CloudWatch 是什么？我们为什么要使用CloudWatch？
答案：Amazon CloudWatch 是一项针对 AWS 云资源和在 AWS 上运行的应用程序的监控服务。
使用 Amazon CloudWatch 可以收集和跟踪指标、收集和监控日志文件以及设置警报。
Amazon CloudWatch 可以监控各种 AWS 资源，例如 Amazon EC2 实例、Amazon DynamoDB 表、Amazon RDS 数据库实例、应用程序和服务生成的自定义指标以及应用程序生成的所有日志文件。
您可通过使用 Amazon CloudWatch 全面地了解系统的资源使用率、应用程序性能和运行状况。
使用这些分析结果，您可以及时做出反应，保证应用程序顺畅运行。
为了开始监控，您可以使用融合 AWS 最佳实践的自动化控制面板，查看基于账户和资源的指标与警报视图，
并轻松深入分析以了解性能问题的根本原因。


CloudWatch中的metrics是什么？包括哪些种类？我们可以如何使用metrics？
答案：指标是关于您的系统性能的数据。默认情况下，许多服务都提供资源的免费指标
（例如 Amazon EC2 实例、Amazon EBS 卷和 Amazon RDS 数据库实例）。
您还可以启用对某些资源（例如 Amazon EC2 实例）的详细监控，或发布自己的应用程序指标。
Amazon CloudWatch 可以加载您账户中的所有指标（AWS资源指标和应用程序指标) 以进行搜索、绘制图表及设置警报。


CloudWatch Events是什么？可以应用在那些场景。
答案：Amazon CloudWatch Events 提供几乎实时的系统事件流，这些事件描述 Amazon Web Services 中的更改（AWS) 资源的费用。
通过使用可快速设置的简单规则，您可以匹配事件并将事件路由到一个或多个目标函数或流。CloudWatch 事件会随着运营变化的发生而感知这些变化。
CloudWatch Events 将响应这些操作更改并在必要时采取纠正措施，方式是发送消息以响应环境、激活函数、进行更改并捕获状态信息。
您还可以使用 CloudWatch Events 来计划使用 cron 或 rate 表达式在某些时间自行触发的自动化操作。


相关概念理解：metrics，periods，namespace，count，dimensions，statistics。
答案：
Namespaces
A命名空间是 CloudWatch 指标的容器。不同命名空间中的指标彼此独立，因此来自不同应用程序的指标不会被错误地聚合到相同的统计信息中。
Metrics
指标是 CloudWatch 中的基本概念。指标代表一个发布到 CloudWatch 的时间排序的数据点集。可将指标视为要监控的变量，而数据点代表该变量随时间变化的值。
Dimensions
维度是一个名称/值对，它是指标标识的一部分。您可以为一个指标分配最多 10 个维度。
每个指标包含用于描述该指标的特定特征，您可以将维度理解为这些特征的类别。维度可以帮助您设计统计数据计划的结构。
因为维度是指标的唯一标识符的一部分，因此无论您在何时向一个指标添加唯一名称/值对，都会创建该指标的一个新变体。
AWS向 CloudWatch 发送数据的服务将向每个指标附加维度。您可以使用维度筛选 CloudWatch 返回的结果。
Statistics
统计数据是指定时间段内的指标数据汇总。CloudWatch 提供统计数据的依据是您的自定义数据所提供的指标数据点，
或其他AWS服务添加到 CloudWatch。聚合通过使用命名空间、指标名称、维度以及数据点度量单位在您指定的时间段内完成。
Periods
Period是与特定 Amazon CloudWatch 统计信息关联的时间的长度。每项统计信息代表在指定时间段内对收集的指标数据的聚合。
时间段以秒为单位定义。
Units（Count）
所有统计数据都有度量单位。示例单位包括 Bytes、Seconds、Count 和 Percent。

Practice
创建cloudwatch event rule每分钟自动触发Lambda（Lambda功能需要自己实现，向cloudwatch metrics里push自定义的metrics），设置alarm检测task中定义的metric，自定义并监控条件使alarm触发阈值，alarm触发SNS，SNS发告警到邮箱。
创建cloudwatch event rules，每分钟自动触发Lambda（输出固定格式的log message）。为lambda log创建metric filter，匹配log message，创建新的metric，自定义并监控条件使alarm触发阈值，alarm出发SNS，SNS发告警到邮箱。	

Output：
两个cloudformation文件
部署cloudformation后，功能完整，邮箱可以收到报警

```


```bash
put metric value:
$ aws cloudwatch put-metric-data --namespace "SITE/TRAFFIC" --metric-data file://input.json --profile tw-aws-beach --region ap-southeast-2
```