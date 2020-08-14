/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.BookTitle;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Yukino
 */
public class BookTitleDAO {
    private  final Session s = Controller.getSessionFactory().openSession();
    private  Transaction tr = null;
    
    //select all
    public List<BookTitle> selectAllBookTitle(){
        try {
            Criteria c = s.createCriteria(BookTitle.class);
            List<BookTitle> list = c.list();
            return list;
        } catch (Exception e) {
            return null;
        }
        
    }
    
    //Find unique BookTitle by idBookTitle
    public BookTitle findBookTitleById(int id){
            try {
                Criteria c = s.createCriteria(BookTitle.class);
                c.add(Restrictions.eq("idBookTitle", id));
               BookTitle uniResult = (BookTitle) c.uniqueResult();             
                return uniResult;
            } catch (Exception e) {
                return null;
            }
    }
    
    //Insert new BookTitle
    public boolean addBookTitle(BookTitle newBookTitle){
        try {
            tr = s.beginTransaction();
            s.save(newBookTitle);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
            return false;
        }
    }
    
    //Update exist BookTitle
    public  boolean updateBookTitle(BookTitle iBookTitle){
        try {
            tr = s.beginTransaction();
            s.update(iBookTitle);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
            return false;
        }
    }
    
    //delete BookTitle
    public boolean deleteBookTitle(BookTitle iBookTitle) {
        try {
            tr = s.beginTransaction();
            s.delete(iBookTitle);
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
