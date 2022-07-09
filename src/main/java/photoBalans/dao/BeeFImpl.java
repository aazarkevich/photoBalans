package photoBalans.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import photoBalans.models.BeeF;
import photoBalans.service.BeeService;

import java.util.List;

@Repository
public class BeeFImpl implements BeeFDao {
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
//    @Transactional
    public List<BeeF> findNumberDevice(String findNumberDevice) {
        List from_beeF = getSession().createQuery("from BeeF where numberDevice like :number_device and res = :res ")
                .setParameter("number_device", "%" + findNumberDevice + "%")
                .setParameter("res", BeeService.getRes())
                .list();
        return from_beeF;
    }

    @Override
    public List<BeeF> findTpAndLine(String nameTp) {
        List from_beeF = getSession().createQuery("from BeeF where upper(tpAndLine) like upper(:nameTp) and res = :res ")
                .setParameter("nameTp", "%" + nameTp + "%")
                .setParameter("res", BeeService.getRes())
                .list();
        return from_beeF;
    }

    @Override
    public List<BeeF> findAddress(String address) {
        List from_beeF = getSession().createQuery("from BeeF where upper(address) like upper(:address) and res = :res")
                .setParameter("address", "%" + address + "%")
                .setParameter("res", BeeService.getRes())
                .list();
        return from_beeF;
    }

    @Override
    public List<BeeF> findNamePerson(String namePerson) {
        List from_beeF = getSession().createQuery("from BeeF where upper(name) like upper(:namePerson) and res = :res")
                .setParameter("namePerson", "%" + namePerson + "%")
                .setParameter("res", BeeService.getRes())
                .list();
        return from_beeF;
    }

    @Override
    public List<BeeF> findNumberAccount(String numberAccount) {
        List from_beeF = getSession().createQuery("from BeeF where numberAccount like :numberAccount and res = :res")
                .setParameter("numberAccount", "%" + numberAccount + "%")
                .setParameter("res", BeeService.getRes())
                .list();
        return from_beeF;
    }

    @Override
    public List<BeeF> findNameDevice(String nameDevice) {
        List from_beeF = getSession().createQuery("from  BeeF where upper(nameDevice) like upper(:nameDevice) and res = :res")
                .setParameter("nameDevice", "%" + nameDevice + "%")
                .setParameter("res", BeeService.getRes())
                .list();
        return from_beeF;
    }

    @Override
    public List<BeeF> findHouse(String house) {
        List from_beef = getSession().createQuery("from BeeF where upper(house) like upper(:house) and res = :res")
                .setParameter("house", "%" + house + "%")
                .setParameter("res", BeeService.getRes())
                .list();
        return from_beef;
    }


}
