package service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import photoBalans.models.BeeF;
import photoBalans.models.DataPhoto;
import photoBalans.service.BeeService;

import java.util.ArrayList;
import java.util.List;

public class ServicesTest extends Assert {
    private  List<DataPhoto> devicesDataPhoto = new ArrayList<>();
    private  List<BeeF> devicesBeeF = new ArrayList<>();

    @Before
    public void initialData() {
        DataPhoto dataPhoto = new DataPhoto();
        BeeF beeF = new BeeF();
        dataPhoto.setId(1l);
        dataPhoto.setTpAndLine("ТП-386 Т-1 ( Переток СРЭС )");
        dataPhoto.setAddress("АТАРБЕКОВА 86Б");
        dataPhoto.setName("СЕМЕНОВА АННА ВАЛЕРЬЕВНА");
        dataPhoto.setNumberAccount("610602002620");
        dataPhoto.setNameDevice("СЕ 208 C2 849.2.OPR1.QD");
        dataPhoto.setNumberDevice("011293105123943");
        dataPhoto.setHouse("ДОМ");
        devicesDataPhoto.add(dataPhoto);

        beeF.setId(1l);
        beeF.setTpAndLine("ТП-386 Т-1 ( Переток СРЭС )");
        beeF.setAddress("АТАРБЕКОВА 86Б");
        beeF.setName("СЕМЕНОВА АННА ВАЛЕРЬЕВНА");
        beeF.setNumberAccount("610602002620");
        beeF.setNameDevice("СЕ 208 C2 849.2.OPR1.QD");
        beeF.setNumberDevice("011293105123943");
        beeF.setHouse("ДОМ");

        devicesBeeF.add(beeF);
    }

    @Test
    public void equalsDataPhotoBeeFTest() {
        BeeService beeService = new BeeService(null,null,null);
        List<BeeF> beeFList = beeService.equalsDataPhotoAndBeeF(devicesDataPhoto, devicesBeeF);
        assertTrue(beeFList.isEmpty());

    }
}
//java.util.List<DataPhoto> devicesDataPhoto, List<BeeF> devicesBeeF