package photoBalans.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import photoBalans.models.DataPhoto;
import photoBalans.service.BeeService;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DataPhotoImpl implements DataPhotoDao {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        try {
            return sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            return sessionFactory.openSession();
        }
    }

    @Override
    public List<DataPhoto> findNumberDevice(String findNumberDevice) {
        List<DataPhoto> from_dataPhoto = getSession().createQuery("from DataPhoto where numberDevice like :number_device and res = :res order by id desc")
                .setParameter("number_device", "%" + findNumberDevice + "%")
                .setParameter("res", BeeService.getRes())
                .list();
        return from_dataPhoto;
    }

    @Override
    public List<DataPhoto> findTpAndLine(String nameTp) {
        List from_dataPhoto = getSession().createQuery("from DataPhoto where upper(tpAndLine) like upper(:nameTp) and res = :res ")
                .setParameter("nameTp", "%" + nameTp + "%")
                .setParameter("res", BeeService.getRes())
                .list();
        return from_dataPhoto;
    }

    @Override
    public List<DataPhoto> findAddress(String address) {
        List from_dataPhoto = getSession().createQuery("from DataPhoto where upper(address) like upper(:address) and res = :res")
                .setParameter("address", "%" + address + "%")
                .setParameter("res", BeeService.getRes())
                .list();
        return from_dataPhoto;
    }

    @Override
    public List<DataPhoto> findNamePerson(String namePerson) {
        List from_dataPhoto = getSession().createQuery("from DataPhoto where upper(name) like upper(:namePerson) and res = :res")
                .setParameter("namePerson", "%" + namePerson + "%")
                .setParameter("res", BeeService.getRes())
                .list();
        return from_dataPhoto;
    }

    @Override
    public List<DataPhoto> findNumberAccount(String numberAccount) {
        List from_dataPhoto = getSession().createQuery("from DataPhoto where numberAccount like :numberAccount and res = :res")
                .setParameter("numberAccount", "%" + numberAccount + "%")
                .setParameter("res", BeeService.getRes())
                .list();
        return from_dataPhoto;
    }

    @Override
    public List<DataPhoto> findNameDevice(String nameDevice) {
        List from_dataPhoto = getSession().createQuery("from  DataPhoto where upper(nameDevice) like upper(:nameDevice) and res = :res")
                .setParameter("nameDevice", "%" + nameDevice + "%")
                .setParameter("res", BeeService.getRes())
                .list();
        return from_dataPhoto;
    }

    @Override
    public List<DataPhoto> findHouse(String house) {
        List from_dataPhoto = getSession().createQuery("from DataPhoto where upper(house) like upper(:house) and res = :res")
                .setParameter("house", "%" + house + "%")
                .setParameter("res", BeeService.getRes())
                .list();
        return from_dataPhoto;
    }

    @Override
    public void save(DataPhoto dataPhoto) {
//        getSession().beginTransaction();
        getSession().save(dataPhoto);
//        getSession().getTransaction().commit();
    }

}
