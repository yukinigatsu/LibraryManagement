/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Reader;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Yukino
 */
public class ReaderDAO {
    private  final Session s = Controller.getSessionFactory().openSession();
    private  Transaction tr = null;
     //select all
    public List<Reader> selectAllReader(){
        try {
            Criteria c = s.createCriteria(Reader.class);
            List<Reader> list = c.list();
            return list;
        } catch (Exception e) {
            return null;
        }
        
    }
    
    //Find unique Reader by idLibrarian
    public Reader findReaderById(int id){
            try {
                Criteria c = s.createCriteria(Reader.class);
                c.add(Restrictions.eq("idReader", id));
                Reader uniResult = (Reader) c.uniqueResult();             
                return uniResult;
            } catch (Exception e) {
                return null;
            }
    }
    
  public List<Reader> findReaderByName(String strName){
        try {
            Criteria c = s.createCriteria(Reader.class);
            c.add(Restrictions.like("name", strName,MatchMode.ANYWHERE));
            List<Reader> temp =  c.list();
            return temp;
        } catch (Exception e) {
            return null;
        }  
    }
    
    //Insert new Reader
    public boolean addReader(Reader newReader){
        try {
            tr = s.beginTransaction();
            s.save(newReader);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
            return false;
        }
    }
    
    //Update exist Reader
    public  boolean updateReader(Reader iReader){
        try {
            tr = s.beginTransaction();
            s.update(iReader);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
            return false;
        }
    }
    
    //delete Reader
    public boolean deleteReader(Reader iReader) {
        try {
            tr = s.beginTransaction();
            s.delete(iReader);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
            return false;
        }
    }
    
    public Long countReader(){
        try {
            Criteria c = s.createCriteria(Reader.class);
            c.setProjection(Projections.rowCount());
            Long l = (Long) c.uniqueResult();
            return l;          
        } catch (Exception e) {
            return null;
        }  
    }
    
    public void closeSessionDAO(){
        s.close();
        tr = null;
    }
}
