package ir.ac.sbu.di.project2.springdatamovielens.repository;

import ir.ac.sbu.di.project2.springdatamovielens.model.Genre;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface GenreRepository extends Neo4jRepository<Genre, Long> {

    @Query("MATCH (g:Genre)<-[:has_genre]-(:Movie {movie_title:{0}}) RETURN g LIMIT 5")
    Iterable<Genre> getMovieGenres(String movieTitle);

}
