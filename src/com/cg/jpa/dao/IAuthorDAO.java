package com.cg.jpa.dao;

import com.cg.jpa.entity.Author;

public interface IAuthorDAO {
    boolean addAuthor(Author newAuthor);
    boolean updateAuthor(Author modifiedAuthor);
    Author removeAuthor(int authorID);
    Author getAuthor(int authorID);
}
