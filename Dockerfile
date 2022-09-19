FROM openjdk:8-jdk-alpine

LABEL image.author="zaid.hamasha@gmail.com"

#default values
ARG database_type="h2"
ARG java_opts="-Xmx2024M -Xms1024M"

ENV DBTYPE=$database_type
ENV JAVAOPS=$java_opts

WORKDIR /opt

COPY --chown=nobody:nobody   ./target/lab*.jar   /opt/lab.jar

EXPOSE 8090

CMD java $JAVAOPS -jar -Dspring.profiles.active=$DBTYPE /opt/lab.jar
