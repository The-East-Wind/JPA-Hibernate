package com.cg.jpa.service;

import com.cg.jpa.entity.Author;

public interface IAuthorService {
    boolean addNewAuthor(Author newAuthor);
    Author removeAuthor(int authorID);
    Author viewAuthor(int authorID);
    boolean updateAuthor(Author modifiedAuthor);
}
