package test.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import test.entity.Geography;
import test.service.HibernateUtil;

import java.util.List;

@Repository
public class AppDaoImpl implements AppDao {
    private Transaction transaction;
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Geography> allInfoDao() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Geography", Geography.class).list();
    }

    @Override
    public boolean addNewCityDao(Geography geography) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(geography);
        return true;
    }

    @Override
    public Geography findByIdDao(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Geography.class, id);
    }

    @Override
    public void editNoteDao(Geography geography) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(geography);
    }

    @Override
    public void deleteNoteDao(Geography geography) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(geography);
    }

    @Override
    public Geography findByNameDao(String cityName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Geography where city = :cityName");
        query.setParameter("cityName", cityName);
        if(query.list().isEmpty()){
            return null;
        } else {
            Geography geography = (Geography) query.getSingleResult();
            return geography;
        }
    }

}
