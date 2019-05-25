package ir.ac.sbu.di.project2.springdatamovielens.repository;

import ir.ac.sbu.di.project2.springdatamovielens.model.Movie;
import ir.ac.sbu.di.project2.springdatamovielens.model.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface UserRepository extends Neo4jRepository<User, Long> {

    @Query("MATCH (u:User {username: {0}}) RETURN u")
    User find(String username);


    @Query("MATCH (m:Movie {name:{0}})-[directed_by]->(d:Director) RETURN m")
    Iterable<Movie> findMovieDirectedBy(String director);

    @Query("MATCH (u1:User {username: {0}})-[r1:RATE]->(m:Movie) WITH m as m, r1 as r1, u1 as u1 MATCH (u2:User)-[r2:RATE]->(:Movie {movie_title: m.movie_title}) WHERE r1.rate > 3 AND r2.rate > 3 AND u1.username <> u2.username WITH u2 as user, COUNT(m) as mutual WHERE mutual > 2 RETURN user LIMIT 1")
    User findSimilarUser(String username);
}
