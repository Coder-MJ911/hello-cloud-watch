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
sls deploy
```


```html
Basic
CloudWatch 是什么？我们为什么要使用CloudWatch？
CloudWatch中的metrics是什么？包括哪些种类？我们可以如何使用metrics？
CloudWatch Events是什么？可以应用在那些场景。
相关概念理解：metrics，periods，namespace，count，dimensions，statistics。


Practice
创建cloudwatch event rule每分钟自动触发Lambda（Lambda功能需要自己实现，向cloudwatch metrics里push自定义的metrics），设置alarm检测task中定义的metric，自定义并监控条件使alarm触发阈值，alarm触发SNS，SNS发告警到邮箱。
创建cloudwatch event rules，每分钟自动触发Lambda（输出固定格式的log message）。为lambda log创建metric filter，匹配log message，创建新的metric，自定义并监控条件使alarm触发阈值，alarm出发SNS，SNS发告警到邮箱。	

Output：
两个cloudformation文件
部署cloudformation后，功能完整，邮箱可以收到报警

```
