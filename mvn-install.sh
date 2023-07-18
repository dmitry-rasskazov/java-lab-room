#!/usr/bin/env sh

echo ">>>>>>>>> Maven installation <<<<<<<<<"
mvn -s settings.xml -P gitlab-profile clean install