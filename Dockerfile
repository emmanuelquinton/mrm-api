FROM adoptopenjdk:11-jre-hotspot
WORKDIR /mrm-application/module
COPY build/libs /app/lib

EXPOSE 8080
ENV JAVA_OPTS="-Xms2048M -Xmx2048M"

ENTRYPOINT java $JAVA_OPTS -cp .:./lib/* \
 $(grep Start-Class /app/META-INF/MANIFEST.MF| tr '\r' ' '| cut -d' ' -f2)
HEALTHCHECK --interval=30s --timeout=3s CMD curl -f http://localhost:8081/app/management/health || exit 1