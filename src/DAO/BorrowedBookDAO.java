/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.BorrowedBook;
import Entities.Reader;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
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
    
    public List<BorrowedBook> selectBooksNotReturn(Reader iReader){
         try {
            Criteria c = s.createCriteria(BorrowedBook.class);
            c.add(Restrictions.eq("reader", iReader));
            c.add(Restrictions.eq("isReturn", (byte) 0));
            List<BorrowedBook> list = c.list();
            return list;
        } catch (Exception e) {
            return null;
        }  
    }
    
    //Insert new BorrowedBook
    public boolean addBorrowedBook(BorrowedBook newBorrowedBook){
        try {
            tr = s.beginTransaction();
            s.save(newBorrowedBook);
            tr.commit();
            tr = null;
            return true;
        } catch (Exception e) {
            tr.rollback();
            tr = null;
            e.printStackTrace();
            return false;
        }
    }
    
    //over due borrowed book list
    public List<BorrowedBook> overDueList(){
        try {
            String HQL = "from BorrowedBook t where t.expiredDate < CURRENT_DATE() and t.isReturn = 0";
            Query q = s.createQuery(HQL);   
            List<BorrowedBook> list = q.list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
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
