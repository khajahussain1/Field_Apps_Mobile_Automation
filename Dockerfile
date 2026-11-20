FROM maven:3.9-eclipse-temurin-21
WORKDIR /app
COPY . .
RUN mvn dependency:go-offline
CMD ["mvn","clean","test"]

#FROM maven:3.9-eclipse-temurin-17
#WORKDIR /app
#COPY pom.xml .
#RUN mvn -B dependency:go-offline
#COPY . .
#CMD ["mvn", "test"]

#docker build -t appium-bdd-tests .
#docker run --rm appium-bdd-tests