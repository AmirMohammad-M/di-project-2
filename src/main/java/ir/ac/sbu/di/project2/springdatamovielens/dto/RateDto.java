package ir.ac.sbu.di.project2.springdatamovielens.dto;

public class RateDto {
    private String username;
    private String movieTitle;
    private int rate;

    public RateDto() {
    }

    public RateDto(String username, String movieTitle, int rate) {
        this.username = username;
        this.movieTitle = movieTitle;
        this.rate = rate;
    }

    public String getUsername() {
        return username;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public int getRate() {
        return rate;
    }


}
