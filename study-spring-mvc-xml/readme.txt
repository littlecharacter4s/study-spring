构建Web项目or模块的正确打开方式：
1、new project or module:注意不要勾选Create from archetype -> org.apache.maven.archetypes:maven-archetype-webapp(web版本太老，还得删除，重建)
2、pom.xml配置打war包
3、File->Project Structure->Modules->右键模块名->Web(把原来的删除，在右键添加一个)
   Path：%root_path%\src\main\webapp\WEB-INF\web.xml
   Web Resource Directory:%root_path%\src\main\webapp
4、在webapp下创建index.html(路径和web.xml中welcome-file指定的路径一致即可)
5、web.xml中添加：
    <display-name>display_name</display-name>
    <welcome-file-list>
        <welcome-file>index.html</welcome-file>
    </welcome-file-list>
6、Run->Edit Configurations->+->Tomcat Server->Local：tomcat配置和Deployment
7、run|debug



