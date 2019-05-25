package ir.ac.sbu.di.project2.springdatamovielens.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Tag {
    @GraphId
    private Long id;

    private String title;

    public String getTitle() {
        return title;
    }
}
