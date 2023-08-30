# Movies API Project

## Description
The Movie API Project is designed to add and receive informations about movies.

## Installation
1. Clone the repository to your local machine.

```
git clone https://github.com/DamianZajac01/moviesapi.git
```
2. Navigate to the project directory.

```
cd moviesapi
```

3. Build and run the project using your preferred Java IDE.

## Technologies Used
- Java 17
- Spring Framework
- Hibernate
- Lombok
- Jackson JSON library
- Postman for making API request

## Endpoints
- `GET /api/movies` Returns all movies in database.
- `GET /api/movies/{movieId}` Returns a movie by ID.
- `POST /api/movies` Adds a movie to the database by specifying the data as JSON.
- `PUT /api/movies/{movieId}` Update a movie in the database by specifying the data as JSON and providing ID of a movie.
- `DELETE /api/movies/{movieId}` Delete a movie from the database by providing ID of a movie.
