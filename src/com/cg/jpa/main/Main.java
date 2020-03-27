package com.cg.jpa.main;

import com.cg.jpa.entity.Author;
import com.cg.jpa.entity.Greet;
import com.cg.jpa.service.AuthorServiceImpl;
import com.cg.jpa.service.IAuthorService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    static void lab1Demo(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAUnit");
        EntityManager em = emf.createEntityManager();
        Greet greet = new Greet();
        greet.setMessage("Hello,World!");
        em.getTransaction().begin();
        em.persist(greet);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    static void lab2Demo(){
        IAuthorService service = new AuthorServiceImpl();
        // Insert
        Author newAuthor = new Author("Ragnar","","Lothbrok","9088876500");
        if(service.addNewAuthor(newAuthor))
            System.out.println("Author added successfully!");
        else
            System.out.println("Sorry!An error occurred.");
        newAuthor = new Author("Walter","Hartwell","White","6034373230");
        if(service.addNewAuthor(newAuthor))
            System.out.println("Author added successfully!");
        else
            System.out.println("Sorry!An error occurred.");
        // View
        System.out.println("**** Before Update ****");
        Author viewAuthor = service.viewAuthor(10000);
        if(viewAuthor==null)
            System.out.println("No author exists with the given ID");
        else
            System.out.println(viewAuthor);
        Author updatedAuthor = new Author("Ragnar","","Lothbrok","9990008877");
        updatedAuthor.setAuthorId(10000);
        if(service.updateAuthor(updatedAuthor))
            System.out.println("Updated Successfully");
        else
            System.out.println("Update Failed!");
        System.out.println("**** After Update ****");
        viewAuthor = service.viewAuthor(10000);
        if(viewAuthor==null)
            System.out.println("No author exists with the given ID");
        else
            System.out.println(viewAuthor);
        // Remove
        Author deletedAuthor = service.removeAuthor(10000);
        if(viewAuthor==null)
            System.out.println("No author exists with the given ID");
        else
            System.out.println("Deleted Author:"+deletedAuthor);
    }
    public static void main(String[] args) {
        //lab1Demo();
        lab2Demo();
    }
}
