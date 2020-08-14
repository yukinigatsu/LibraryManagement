/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.BorrowedBook;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Yukino
 */
public class BorrowedBookDAO {
    private  final Session s = Controller.getSessionFactory().openSession();
    private  Transaction tr = null;
    
            //select all
    public List<BorrowedBook> selectAllAccount(){
        try {
            Criteria c = s.createCriteria(BorrowedBook.class);
            List<BorrowedBook> list = c.list();
            return list;
        } catch (Exception e) {
            return null;
        }
        
    }
   /* 
    //Find BookTitle by idBookTitle
    public BorrowedBook findUserByUsername(int idReader, int idBook){
            try {
                Criteria c = s.createCriteria(BookTitle.class);
                c.add(Restrictions.eq("idBookTitle", id));
               BookTitle uniResult = (BookTitle) c.uniqueResult();             
                return uniResult;
            } catch (Exception e) {
                return null;
            }
    }*/
    
    //Insert new BorrowedBook
    public boolean addBorrowedBook(BorrowedBook newBorrowedBook){
        try {
            tr = s.beginTransaction();
            s.save(newBorrowedBook);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
            return false;
        }
    }
    
    //Update exist BorrowedBook
    public  boolean updateBorrowedBook(BorrowedBook iBorrowedBook){
        try {
            tr = s.beginTransaction();
            s.update(iBorrowedBook);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
            return false;
        }
    }
    
    //delete BorrowedBook
    public boolean deleteBorrowedBook(BorrowedBook iBorrowedBook) {
        try {
            tr = s.beginTransaction();
            s.delete(iBorrowedBook);
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
