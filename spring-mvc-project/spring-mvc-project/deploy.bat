@echo off

SET JAVA_HOME=%JAVA_17_HOME%

echo ================ Building project war =======================
call mvn clean package

echo ================ Deploying war to tomcat ====================
copy /y "target\spring-mvc-project.war" "%CATALINA_HOME%\webapps" > nul

echo ================= Deployment completed successfully ==========