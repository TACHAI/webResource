#!/usr/bin/env bash

mvn clean packge -Dmaven.test.skip=true -U

docker build -t hub.c.163.com/tc1206966083/webresource .

docker push hub.c.163.com/tc1206966083/webresource