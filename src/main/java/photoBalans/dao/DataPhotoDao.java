package photoBalans.dao;

import photoBalans.models.DataPhoto;

import java.util.List;

public interface DataPhotoDao {
    List<DataPhoto> findNumberDevice(String findNumberDevice);
    List<DataPhoto> findTpAndLine(String nameTp);
    List<DataPhoto> findAddress(String address);
    List<DataPhoto> findNamePerson(String namePerson);
    List<DataPhoto> findNumberAccount(String numberAccount);
    List<DataPhoto> findNameDevice(String nameDevice);
    List<DataPhoto> findHouse(String house);
    void save(DataPhoto dataPhoto);
}
