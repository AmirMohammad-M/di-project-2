package ir.ac.sbu.di.project2.springdatamovielens.repository;

import ir.ac.sbu.di.project2.springdatamovielens.model.Rate;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface RateRepository extends Neo4jRepository<Rate, Long> {

    @Query("MATCH (u:User {username: {0}})-[r:RATE]->(m:Movie) RETURN u,r,m ORDER BY r.ratedAt desc")
    Iterable<Rate> getTimeSortedRates(String username);

    @Query("MATCH (u:User {username: {0}})-[r:RATE]->(m:Movie {movie_title:{1}}) RETURN u,r,m")
    Rate findOne(String username, String movieTitle);

    @Query("MATCH (u:User {username: {0}})-[r:RATE]->(m:Movie {movie_title:{2}}) SET r.rate={1} SET r.ratedAt={3} RETURN u,r,m ")
    void changeRate(String username, Integer newRate, String movieTitle, Long newTime);
}
