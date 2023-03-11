##* Run DB seperately
compose_db_up_v1:
	docker-compose -f docker-compose.db.yml up -d --build

compose_db_down_v1:
	docker-compose -f docker-compose.db.yml down

compose_db_up_v2:
	docker compose -f docker-compose.db.yml up -d --build

compose_db_down_v2:
	docker compose -f docker-compose.db.yml down


##? Run service dev
compose_dev_up_v1:
	docker-compose -f docker-compose.yml up -d --build

compose_dev_down_v1:
	docker-compose -f docker-compose.yml down

compose_dev_up_v2:
	docker compose -f docker-compose.yml up -d --build

compose_dev_down_v2:
	docker compose -f docker-compose.yml down


##? Run service prod
compose_prod_up_v1:
	docker-compose -f docker-compose.prod.yml up -d --build

compose_prod_down_v1:
	docker-compose -f docker-compose.prod.yml down

compose_prod_up_v2:
	docker compose -f docker-compose.prod.yml up -d --build

compose_prod_down_v2:
	docker compose -f docker-compose.prod.yml down