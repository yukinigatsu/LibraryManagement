/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Librarian;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Yukino
 */
public class LibrarianDAO {
    private  final Session s = Controller.getSessionFactory().openSession();
    private  Transaction tr = null;
    
     //select all
    public List<Librarian> selectAllLibrarian(){
        try {
            Criteria c = s.createCriteria(Librarian.class);
            List<Librarian> list = c.list();
            return list;
        } catch (Exception e) {
            return null;
        }
        
    }
    
    //Find unique Librarian by idLibrarian
    public Librarian findLibrarianById(int id){
            try {
                Criteria c = s.createCriteria(Librarian.class);
                c.add(Restrictions.eq("idLibrarian", id));
                Librarian uniResult = (Librarian) c.uniqueResult();             
                return uniResult;
            } catch (Exception e) {
                return null;
            }
    }
    
    //Insert new Librarian
    public boolean addLibrarian(Librarian newLibrarian){
        try {
            tr = s.beginTransaction();
            s.save(newLibrarian);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
            return false;
        }
    }
    
    //Update exist Librarian
    public  boolean updateLibrarian(Librarian iLibrarian){
        try {
            tr = s.beginTransaction();
            s.update(iLibrarian);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
            return false;
        }
    }
    
    //delete Librarian
    public boolean deleteLibrarian(Librarian iLibrarian) {
        try {
            tr = s.beginTransaction();
            s.delete(iLibrarian);
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
