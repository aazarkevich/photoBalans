package photoBalans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import photoBalans.dao.BeeFDao;
import photoBalans.dao.BeeFImpl;
import photoBalans.dao.DataPhotoDao;
import photoBalans.dao.UserDao;
import photoBalans.models.BeeF;
import photoBalans.models.DataPhoto;

import java.util.List;

@Service
public class BeeService {
    private static String res;
    @Autowired
    private UserDao userDao;
    @Autowired
    private BeeFDao beeF;
    @Autowired
    private DataPhotoDao dataPhotoDao;

    public List findDevice(String selectFind, String find) {
        switch (selectFind) {
            case "serial":
                List<DataPhoto> numberDevice = dataPhotoDao.findNumberDevice(find);
                System.out.println(numberDevice);
                if (!numberDevice.isEmpty()) {
                    return numberDevice;
                } else {
                    return beeF.findNumberDevice(find);
                }
            case "fio":
                List<DataPhoto> namePerson = dataPhotoDao.findNamePerson(find);
                if (!namePerson.isEmpty()) {
                    return namePerson;
                } else {
                    return beeF.findNamePerson(find);
                }
            case "address":
                List<DataPhoto> address = dataPhotoDao.findAddress(find);
                if (!address.isEmpty()) {
                    return address;
                } else {
                    return beeF.findAddress(find);
                }
            case "personal":
                List<DataPhoto> numberAccount = dataPhotoDao.findNumberAccount(find);
                if(!numberAccount.isEmpty()) {
                    return numberAccount;
                } else {
                    return beeF.findNumberAccount(find);
                }
            case "house":
                List<DataPhoto> house = dataPhotoDao.findHouse(find);
                if(!house.isEmpty()) {
                    return house;
                } else {
                    return beeF.findHouse(find);
                }
            case "tpAndLine":
                List<DataPhoto> tpAndLine = dataPhotoDao.findTpAndLine(find);
                if(!tpAndLine.isEmpty()) {
                    return tpAndLine;
                } else {
                    return beeF.findTpAndLine(find);
                }
            default:
                return null;
        }
    }

    public static String getRes() {
        return res;
    }

    public static void setRes(String res) {
        BeeService.res = res;
    }
}
