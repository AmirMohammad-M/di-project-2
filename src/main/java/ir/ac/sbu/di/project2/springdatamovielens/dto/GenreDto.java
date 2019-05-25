package ir.ac.sbu.di.project2.springdatamovielens.dto;

public class GenreDto {
    private String genreName;
    private Integer moviesCount;

    public GenreDto(String genreName, Integer moviesCount) {
        this.genreName = genreName;
        this.moviesCount = moviesCount;
    }

    public String getGenreName() {
        return genreName;
    }

    public Integer getMoviesCount() {
        return moviesCount;
    }
}
