FROM hub.c.163.com/library/java:8-alpine

MAINTAINER TACHAI 1206966083@qq.com

ADD order-server/target/*.jar webResource.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/webResource.jar"]

