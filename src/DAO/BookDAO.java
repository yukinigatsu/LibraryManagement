/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Book;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Yukino
 */
public class BookDAO {
    private  final Session s = Controller.getSessionFactory().openSession();
    private  Transaction tr = null;
    
    //select all
    public List<Book> selectAllBook(){
        try {
            Criteria c = s.createCriteria(Book.class);
            List<Book> list = c.list();
            return list;
        } catch (Exception e) {
            return null;
        }
        
    }
    
    //Find unique Book by idBook
    public Book findBookById(int id){
            try {
                Criteria c = s.createCriteria(Book.class);
                c.add(Restrictions.eq("idBook", id));
                Book uniResult = (Book) c.uniqueResult();             
                return uniResult;
            } catch (Exception e) {
                return null;
            }
    }
    
    //Insert new Book
    public boolean addBook(Book newBook){
        try {
            tr = s.beginTransaction();
            s.save(newBook);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
            return false;
        }
    }
    
    //Update exist Book
    public  boolean updateBook(Book iBook){
        try {
            tr = s.beginTransaction();
            s.update(iBook);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
            return false;
        }
    }
    
    //delete Book
    public boolean deleteBook(Book iBook) {
        try {
            tr = s.beginTransaction();
            s.delete(iBook);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
            return false;
        }
    }
    
    public void closeSessionDAO(){
        s.close();
        tr = null;
    }
}
