
package com.miroslav.newcv.dao.impl;

import com.miroslav.newcv.dao.InputDAO;
import com.miroslav.newcv.domain.Input;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class InputDAOImpl implements InputDAO {
    
    @Autowired
    private SessionFactory sessionFactory;

    private Session openSession() {
        return getSessionFactory().getCurrentSession();
    }

    public Session getCurrentSession() {
        return getSessionFactory().getCurrentSession();
    }

    @Override
    public void savingCV(Input input) {

        Session s = getCurrentSession();
        Transaction trans = s.beginTransaction();
        getCurrentSession().save(input);
        trans.commit();
    }
    
    @Override
    public void updateCV(Input input) {
       Session s = getCurrentSession();
        Transaction trans = s.beginTransaction();
        getCurrentSession().update(input);
        trans.commit();
    }

    @Override
    public Input getCVId(Integer cvID) {
        
         Session s = getCurrentSession();
        Transaction trans = s.beginTransaction();
        Input cv = (Input) s.get(Input.class, cvID);
        trans.commit();

        return cv;     
    }
     
     @Override
    public List<Input> allCVs() {
        
        Session s = getCurrentSession();
        Transaction trans = s.beginTransaction();
        List<Input> CVs = s.createCriteria(Input.class).list();
        trans.commit();

        return CVs;       
    }
    
    @Override
    public void deleteCV(Input input) {
        Session s = getCurrentSession();
        Transaction trans = s.beginTransaction();
        getCurrentSession().delete(input);
        trans.commit();
    }
 
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }  
}
