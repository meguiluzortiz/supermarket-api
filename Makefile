clean-verify:
	./mvnw clean verify
	
run:
	./mvnw spring-boot:run
	
run-debug:
	./mvnw spring-boot:run -Dspring-boot.run.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=8000"

run-prod:
	java -jar -Dspring.profiles.active=prod ./target/supermarket-api-0.0.1-SNAPSHOT.jar

heroku-login:
	heroku login

heroku-create-app:
	heroku create meguiluzortiz-supermarket

heroku-create-db:
	heroku addons:create heroku-postgresql --app meguiluzortiz-supermarket

heroku-link-app:
	heroku git:remote --app meguiluzortiz-supermarket

heroku-config:
	heroku config --app meguiluzortiz-supermarket

heroku-logs:
	heroku logs --tail --app meguiluzortiz-supermarket