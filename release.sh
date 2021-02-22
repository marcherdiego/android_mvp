#!/bin/bash
./gradlew signJars

# Events
rm events/build/outputs/aar/events-debug.aar
rm events/build/outputs/aar/events-debug.aar.asc
mv events/build/libs/* events/build/outputs/aar
mv events/build/poms/pom-default.xml events/build/outputs/aar/events-1.0.0.pom
mv events/build/poms/pom-default.xml.asc events/build/outputs/aar/events-1.0.0.pom.asc

# Coroutines
rm coroutines/build/outputs/aar/coroutines-debug.aar
rm coroutines/build/outputs/aar/coroutines-debug.aar.asc
mv coroutines/build/libs/* coroutines/build/outputs/aar
mv coroutines/build/poms/pom-default.xml coroutines/build/outputs/aar/coroutines-1.0.0.pom
mv coroutines/build/poms/pom-default.xml.asc coroutines/build/outputs/aar/coroutines-1.0.0.pom.asc
