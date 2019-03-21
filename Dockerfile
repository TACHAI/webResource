FROM hub.c.163.com/library/java:8-alpine

MAINTAINER TACHAI 1206966083@qq.com

ADD target/*.jar webResource.jar

EXPOSE 82

ENTRYPOINT ["java","-jar","/webResource.jar"]