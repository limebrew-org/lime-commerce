##* Run DB seperately
compose_db_up_v1:
	docker-compose -f docker-compose.db.yml up -d --build

compose_db_down_v1:
	docker-compose -f docker-compose.db.yml down