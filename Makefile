run-prod:
	java -jar -Dspring.profiles.active=prod ./target/supermarket-api-0.0.1-SNAPSHOT.jar

heroku-login:
	heroku login

heroku-create-app:
	heroku create meguiluzortiz-supermarket

heroku-create-db:
	heroku addons:create heroku-postgresql --app meguiluzortiz-supermarket

heroku-config:
	heroku config --app meguiluzortiz-supermarket

heroku-logs:
	heroku logs --tail --app meguiluzortiz-supermarket