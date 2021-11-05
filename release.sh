#!/bin/bash
./gradlew clean && ./gradlew signJars

# Events
rm events/build/outputs/aar/events-debug.aar
rm events/build/outputs/aar/events-debug.aar.asc
mv events/build/libs/* events/build/outputs/aar
mv events/build/poms/pom-default.xml events/build/outputs/aar/events-pom.pom
mv events/build/poms/pom-default.xml.asc events/build/outputs/aar/events-pom.pom.asc

# Coroutines
rm coroutines/build/outputs/aar/coroutines-debug.aar
rm coroutines/build/outputs/aar/coroutines-debug.aar.asc
mv coroutines/build/libs/* coroutines/build/outputs/aar
mv coroutines/build/poms/pom-default.xml coroutines/build/outputs/aar/coroutines-pom.pom
mv coroutines/build/poms/pom-default.xml.asc coroutines/build/outputs/aar/coroutines-pom.pom.asc
