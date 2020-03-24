package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.dao.AppDao;
import test.entity.Geography;

import java.util.List;

@Service
public class AppServiceImpl implements AppService {

    private AppDao appDao;

    @Autowired
    public void setAppDao(AppDao appDao) {
        this.appDao = appDao;
    }

    @Override
    @Transactional
    public List<Geography> allInfo() {
        return appDao.allInfoDao();
    }

  /*  public String findByName(String cityName){
        Geography geography = appDao.findByNameDao();
        String nameCity = geography.getNameCity();
        return nameCity;
    }*/
}
