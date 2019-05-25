package ir.ac.sbu.di.project2.springdatamovielens.dto;

public class MovieDto {
    private String movieId;
    private String movieTitle;

    public MovieDto() {
    }

    public MovieDto(String movieId, String movieTitle) {
        this.movieId = movieId;
        this.movieTitle = movieTitle;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }
}
