package test.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import test.entity.Geography;

import java.util.List;

@Repository
public class AppDaoImpl implements AppDao {

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
}
