package photoBalans.dao;

import photoBalans.models.BeeF;

import java.util.List;

public interface BeeFDao {
    List<BeeF> findNumberDevice(String findNumberDevice);
    List<BeeF> findTpAndLine(String nameTp);
    List<BeeF> findAddress(String address);
    List<BeeF> findNamePerson(String namePerson);
    List<BeeF> findNumberAccount(String numberAccount);
    List<BeeF> findNameDevice(String nameDevice);
    List<BeeF> findHouse(String house);
}
