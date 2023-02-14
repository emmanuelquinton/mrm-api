FROM adoptopenjdk:11.0.11_9-jre-hotspot
WORKDIR /mrm

COPY mrm-application-module/build/libs/*.jar /app/lib/mrm.jar

EXPOSE 8080
ENV JAVA_OPTS="-Xms2048M -Xmx2048M"

ENTRYPOINT java $JAVA_OPTS -jar /app/lib/mrm.jar

HEALTHCHECK --interval=30s --timeout=3s CMD curl -f http://localhost:8080/app/management/health || exit 1