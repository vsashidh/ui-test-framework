FROM maven:3.3.9-jdk-8-alpine
WORKDIR ui-tests
RUN pwd
COPY src src/
COPY application-vm.properties src/test/resources/application.properties
COPY pom.xml .
COPY setup-vm.sh setup.sh
# CMD ./setup.sh
RUN ls