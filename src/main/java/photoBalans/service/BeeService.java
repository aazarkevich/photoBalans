package photoBalans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import photoBalans.dao.BeeFDao;
import photoBalans.dao.DataPhotoDao;
import photoBalans.dao.UserDao;
import photoBalans.models.BeeF;
import photoBalans.models.DataPhoto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BeeService {
    private static String res;
    private BeeFDao beeF;
    private DataPhotoDao dataPhotoDao;

    @Autowired
    public BeeService( BeeFDao beeF, DataPhotoDao dataPhotoDao) {
        this.beeF = beeF;
        this.dataPhotoDao = dataPhotoDao;
    }

    public List findDeviceBeef(String selectFind, String find) {
        switch (selectFind) {
            case "serial":
                List<DataPhoto> dataPhotoDaoNumberDevice = dataPhotoDao.findNumberDevice(find);
                List<BeeF> beeFNumberDevice = beeF.findNumberDevice(find);
                List<BeeF> rezultNumberDevice = equalsDataPhotoAndBeeF(dataPhotoDaoNumberDevice, beeFNumberDevice);
                return rezultNumberDevice;
            case "fio":
                List<DataPhoto> dataPhotoDaoNamePerson = dataPhotoDao.findNamePerson(find);
                List<BeeF> beeFNamePerson = beeF.findNamePerson(find);
                List<BeeF> rezultNamePerson = equalsDataPhotoAndBeeF(dataPhotoDaoNamePerson, beeFNamePerson);
                return rezultNamePerson;
            case "address":
                List<DataPhoto> dataPhotoDaoAddress = dataPhotoDao.findAddress(find);
                List<BeeF> beeFAddress = beeF.findAddress(find);
                List<BeeF> rezultAddress = equalsDataPhotoAndBeeF(dataPhotoDaoAddress, beeFAddress);
                return rezultAddress;
            case "personal":
                List<DataPhoto> dataPhotoDaoNumberAccount = dataPhotoDao.findNumberAccount(find);
                List<BeeF> beeFNumberAccount = beeF.findNumberAccount(find);
                List<BeeF> rezultNumberAccount = equalsDataPhotoAndBeeF(dataPhotoDaoNumberAccount, beeFNumberAccount);
                return rezultNumberAccount;
            case "house":
                List<DataPhoto> dataPhotoDaoHouse = dataPhotoDao.findHouse(find);
                List<BeeF> beeFHouse = beeF.findHouse(find);
                List<BeeF> rezultHouse = equalsDataPhotoAndBeeF(dataPhotoDaoHouse, beeFHouse);
                return rezultHouse;
            case "tpAndLine":
                List<DataPhoto> dataPhotoDaoTpAndLine = dataPhotoDao.findTpAndLine(find);
                List<BeeF> beeFTpAndLine = beeF.findTpAndLine(find);
                List<BeeF> rezultTpAndLine = equalsDataPhotoAndBeeF(dataPhotoDaoTpAndLine, beeFTpAndLine);
                return rezultTpAndLine;
            default:
                return null;
        }
    }

    public List findDeviceDataPhoto(String selectFind, String find) {
        switch (selectFind) {
            case "serial":
                List<DataPhoto> numberDevice = dataPhotoDao.findNumberDevice(find).stream().distinct().collect(Collectors.toList());
                return numberDevice;
            case "fio":
                List<DataPhoto> namePerson = dataPhotoDao.findNamePerson(find).stream().distinct().collect(Collectors.toList());
                return namePerson;
            case "address":
                List<DataPhoto> address = dataPhotoDao.findAddress(find).stream().distinct().collect(Collectors.toList());
                return address;
            case "personal":
                List<DataPhoto> numberAccount = dataPhotoDao.findNumberAccount(find).stream().distinct().collect(Collectors.toList());
                return numberAccount;
            case "house":
                List<DataPhoto> house = dataPhotoDao.findHouse(find).stream().distinct().collect(Collectors.toList());
                return house;
            case "tpAndLine":
                List<DataPhoto> tpAndLine = dataPhotoDao.findTpAndLine(find).stream().distinct().collect(Collectors.toList());
                return tpAndLine;
            default:
                return null;
        }

    }

    private List<BeeF> equalsDataPhotoAndBeeF(List<DataPhoto> devicesDataPhoto, List<BeeF> devicesBeeF) {
        List<BeeF> filterDeviceBeef = null;
        if (!devicesDataPhoto.isEmpty()) {
            for (DataPhoto deviceDataPhoto : devicesDataPhoto) {
                filterDeviceBeef = devicesBeeF.stream().filter(device ->
                        !device.getAddress().equals(deviceDataPhoto.getAddress()) &
                                !device.getName().equals(deviceDataPhoto.getName()) &
                                !device.getNameDevice().equals(deviceDataPhoto.getNameDevice()) &
                                !device.getNumberAccount().equals(deviceDataPhoto.getNumberAccount()) &
                                !device.getTpAndLine().equals(deviceDataPhoto.getTpAndLine())
                ).collect(Collectors.toList());
            }
        } else {
            return devicesBeeF;
        }
        return filterDeviceBeef;
    }

    public static String getRes() {
        return res;
    }

    public static void setRes(String res) {
        BeeService.res = res;
    }
}
