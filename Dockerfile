FROM eclipse-temurin:11-jre-focal
MAINTAINER vuanhhuy93@gmail.com
ENV TZ=Asia/Ho_Chi_Minh
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
WORKDIR /app
ADD target/grpc-server.jar /app/

CMD ["java", "-jar", "grpc-server.jar"]
