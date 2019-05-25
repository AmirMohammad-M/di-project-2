package ir.ac.sbu.di.project2.springdatamovielens.dto;

public class UserDto {
    private String username;
    private String password;
    private String name;
    private Integer age;

    public UserDto() {
    }

    public UserDto(String username, String password, String name, Integer age) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
