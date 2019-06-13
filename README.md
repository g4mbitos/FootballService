# FootballService
Rest API for manage football teams and football players.

For deployment:
1. Execute commands, for pulling openjdk and postgres images
  docker pull openjdk:8
  docker pull postgres

2. Build JAR file via Maven:
  mvn clean package(install)

3. Build application image:
docker build . -t football-manager

4. Build and run postgre container using this command:
docker run --name postgre-standalone -e POSTGRES_PASSWORD=123 -d postgres

5. Create database using this command:
docker exec -it postgre-standalone psql -U postgres -c "CREATE DATABASE footballdb;"

6. Build and run application container using this command:
docker run -p 8080:8080 --name fm --link postgre-standalone:postgres -d football-manager

Congratulation. You can use REST Api now.
