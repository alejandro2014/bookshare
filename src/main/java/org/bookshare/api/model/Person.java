package org.bookshare.api.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persons")
@Data
public class Person {
    @Id
    private String id;

    private String name;
}
