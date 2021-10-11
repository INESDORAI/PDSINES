#!/bin/bash

cd ../../../target
exec java -jar virtual-smart-city-server-1.0-SNAPSHOT-jar-with-dependencies.jar $*

