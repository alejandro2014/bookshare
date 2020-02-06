package org.bookshare.api.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@Builder
public class Author {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String surname;
    private UUID photoId;
    private Integer birth;
    private Integer death;
    private String biography;
}
