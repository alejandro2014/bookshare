package org.bookshare.api.model;

import lombok.Data;

import java.util.Set;

@Data
public class LibraryGroup {
    private Set<Library> libraries;
}
