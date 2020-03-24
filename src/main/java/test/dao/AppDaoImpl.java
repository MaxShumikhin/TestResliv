package test.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
    public String  findByNameDao(String cityName){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("Description from Geography where City ='"+ cityName +"';",Geography.class);

        return query.getQueryString();
    }
}
