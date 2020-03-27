package com.cg.jpa.service;

import com.cg.jpa.dao.AuthorDAOImpl;
import com.cg.jpa.dao.IAuthorDAO;
import com.cg.jpa.entity.Author;

public class AuthorServiceImpl implements IAuthorService {
    private IAuthorDAO authorDAO;
    public AuthorServiceImpl(){
        authorDAO = new AuthorDAOImpl();
    }
    @Override
    public boolean addNewAuthor(Author newAuthor) {
        return  authorDAO.addAuthor(newAuthor);
    }

    @Override
    public Author removeAuthor(int authorID) {
        return authorDAO.removeAuthor(authorID);
    }

    @Override
    public Author viewAuthor(int authorID) {
        return authorDAO.getAuthor(authorID);
    }

    @Override
    public boolean updateAuthor(Author modifiedAuthor) {
        return authorDAO.updateAuthor(modifiedAuthor);
    }
}
