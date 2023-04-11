install:
	make install-backend && \
	make install-frontend;

install-backend: ./sort-wiki/src
	cd ./sort-wiki && \
	javac -d ./bin @sources.txt; \
	cd ..

install-frontend: ./frontend/package-lock.json
	cd ./frontend && \
	npm install; \
	cd ..

run-backend:
	cd ./sort-wiki && \
	java ./bin/Main & \
	cd .. 

run-frontend:
	cd ./frontend && \
	npm start & \
	cd ..

run:
	make run-backend && \
	make run-frontend

backend-sources-unix: ./sort-wiki/src
	cd ./sort-wiki && \
	find ./src/ -type f -name "*.java" > sources.txt; \
	cd ..

backend-sources-windows: ./sort-wiki/src
	cd ./sort-wiki && \
	dir src /b /s *.java > sources.txt
	cd ..

stop-unix:
	pkill npm; pkill java

stop-windows:
	kill npm; kill java