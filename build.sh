#!/usr/bin/env bash

#mvn clean packge -Dmaven.test.skip=true -U
mvn -B -DskipTests clean package

docker build -t tachai/webresource .

docker push registry.cn-hangzhou.aliyuncs.com/tachai/webresource