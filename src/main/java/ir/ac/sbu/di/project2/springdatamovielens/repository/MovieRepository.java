package ir.ac.sbu.di.project2.springdatamovielens.repository;

import ir.ac.sbu.di.project2.springdatamovielens.model.Movie;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface MovieRepository extends Neo4jRepository<Movie, Long> {

    @Query("MATCH (m:Movie {movie_title: {0}}) RETURN m")
    Movie find(String movieTitle);

    @Query("MATCH (:Movie {movie_title: {0}})-[:has_genre]->(g:Genre) WITH g as g MATCH (m:Movie)-[:has_genre]->(:Genre {name: g.name}) RETURN m LIMIT 3")
    Iterable<Movie> findThreeMoviesOfSameGenre(String movieTitle);

    @Query("MATCH (:User {username: {0}})-[r:RATE]->(m:Movie) WHERE r.rate > 3 RETURN m ORDER BY r.ratedAt desc LIMIT 1")
    Movie getLastLikedMovie(String username);

    @Query("MATCH (:User {username: {0}})-[r:RATE]->(m:Movie) WHERE r.rate > 3 RETURN m ORDER BY r.ratedAt desc LIMIT 3")
    Iterable<Movie> getLastThreeLikedMovies(String username);

    @Query("MATCH (:Genre {name:{0}})<-[:has_genre]-(m:Movie) RETURN COUNT(m)")
    Integer getGenreMoviesCount(String genreName);

    @Query("MATCH (u1:User {username: {0}})-[r1:RATE]->(m:Movie) WITH m as m, r1 as r1, u1 as u1 MATCH (u2:User)-[r2:RATE]->(:Movie {movie_title: m.movie_title}) WHERE r1.rate > 3 AND r2.rate > 3 AND u1.username <> u2.username RETURN SIZE ((u2:User)-[r2:RATE]->(:Movie {movie_title: m.movie_title}))")
    Integer getCountOfMutuallyLikedMovies(String username);
}
