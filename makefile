
install-frontend: ./frontend/package-lock.json
	cd ./frontend && \
	npm install; \
	cd ..

run-frontend:
	cd ./frontend && \
	npm start & \
	cd ..

