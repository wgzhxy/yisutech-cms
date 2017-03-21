################

易速云内容管理系统 1.0

@guangzhong.wgz

@time 2017.2.18

###############

一、启动系统

   1） 先启动sling服务
   2） 打包项目发布到tomcat7


-Dantx.properties=/Users/guangzhong.wgz/antWorkSpace/yisutech-cms/antx.properties
-Dhotcode.confFile=/Users/guangzhong.wgz/antWorkSpace/yisutech-cms/workspace.xml


上传安装到服务器：

scp /Users/guangzhong.wgz/antWorkSpace/yisutech-cms/app/target/app.war root@116.62.101.237:/root/app/project

scp /Users/guangzhong.wgz/antWorkSpace/yisutech-cms/app/target/app.war root@116.62.101.237:/root/app/project


java -Xmx256m -jar jackrabbit-standalone-2.14.0.jar -c /Users/guangzhong.wgz/devSoft/jackrabbit/repository.xml &