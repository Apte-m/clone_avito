Установка докер контейнера БД 
docker run -d --hostname springPoasgres --name pogreb -p 5432:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=123 -e POSTGRES_DB=sweater -v /data:/var/lib/postgresql/data --restart=unless-stopped postgres:14.5
