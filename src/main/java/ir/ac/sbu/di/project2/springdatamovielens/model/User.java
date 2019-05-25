package ir.ac.sbu.di.project2.springdatamovielens.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class User {

    @GraphId
    private Long id;

    private String username;
    private String password;
    private String name;
    private Integer age;

    public User() {
    }

    public User(String username, String password, String name, Integer age) {
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

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
