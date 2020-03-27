package com.cg.jpa.dao;

import com.cg.jpa.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AuthorDAOImpl implements IAuthorDAO {
    private EntityManagerFactory emf;
    private EntityManager em;
    @Override
    public boolean addAuthor(Author newAuthor) {
        emf = Persistence.createEntityManagerFactory("JPAUnit");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(newAuthor);
        em.getTransaction().commit();
        em.close();
        emf.close();
        return true;
    }

    @Override
    public boolean updateAuthor(Author modifiedAuthor) {
        emf = Persistence.createEntityManagerFactory("JPAUnit");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Author updatedAuthor=em.merge(modifiedAuthor);
        em.getTransaction().commit();
        em.close();
        emf.close();
        return updatedAuthor!=null;
    }

    @Override
    public Author removeAuthor(int authorID) {
        emf = Persistence.createEntityManagerFactory("JPAUnit");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Author deletedAuthor = em.find(Author.class,authorID);
        if(deletedAuthor!=null){
            em.remove(deletedAuthor);
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
        return deletedAuthor;
    }

    @Override
    public Author getAuthor(int authorID) {
        emf = Persistence.createEntityManagerFactory("JPAUnit");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Author author = em.find(Author.class,authorID);
        em.getTransaction().commit();
        em.close();
        emf.close();
        return author;
    }
}
