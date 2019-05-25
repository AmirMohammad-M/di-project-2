package ir.ac.sbu.di.project2.springdatamovielens.model;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Director {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
