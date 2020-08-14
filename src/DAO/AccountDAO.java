/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Account;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Yukino
 */
public class AccountDAO {
    private  final Session s = Controller.getSessionFactory().openSession();
    private  Transaction tr = null;
    
    //select all
    public List<Account> selectAllAccount(){
        try {
            Criteria c = s.createCriteria(Account.class);
            List<Account> list = c.list();
            return list;
        } catch (Exception e) {
            return null;
        }
        
    }
    
    //Find unique Account by  username
    public Account findAccountByUsername(String username){
            try {
                Criteria c = s.createCriteria(Account.class);
                c.add(Restrictions.eq("username", username));
                Account uniResult = (Account) c.uniqueResult();             
                return uniResult;
            } catch (Exception e) {
                return null;
            }
    }
    
    //Insert new Account
    public boolean addAccount(Account newAccount){
        try {
            tr = s.beginTransaction();
            s.save(newAccount);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
            return false;
        }
    }
    
    //Update exist Account
    public  boolean updateAccount(Account iAccount){
        try {
            tr = s.beginTransaction();
            s.update(iAccount);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
            return false;
        }
    }
    
    //delete Account
    public boolean deleteAccount(Account iAccount) {
        try {
            tr = s.beginTransaction();
            s.delete(iAccount);
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
