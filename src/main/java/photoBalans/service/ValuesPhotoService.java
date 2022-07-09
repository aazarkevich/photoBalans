package photoBalans.service;

import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;
import jcifs.smb.SmbFileOutputStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import photoBalans.dao.DataPhotoDao;
import photoBalans.models.DataPhoto;

import javax.swing.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Service
@PropertySource(value = {"classpath:application.properties"})
@Transactional
public class ValuesPhotoService {
    @Value("${path.upload}")
    private String pathUpload;
    private DataPhotoDao dataPhotoDao;

    public ValuesPhotoService(DataPhotoDao dataPhotoDao) {
        this.dataPhotoDao = dataPhotoDao;
    }

    public void saveDataPhoto(DataPhoto dataPhoto, MultipartFile file) {
        dataPhoto.setDate(new java.sql.Date(System.currentTimeMillis()));
        try {
            InputStream inputStream = file.getInputStream();
            StringBuilder nameSaveFile = new StringBuilder()
                    .append(dataPhoto.getNumberDevice())
                    .append("_")
                    .append(new SimpleDateFormat("dd.MM.yyyy").format(new Date()))
                    .append("_")
                    .append(file.getOriginalFilename());

            SmbFileOutputStream destFileName = new SmbFileOutputStream(
                    new SmbFile(pathUpload + "/" + nameSaveFile));

            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            byte data[] = new byte[1024];
            int count;
            while ((count = bufferedInputStream.read(data, 0, 1024)) != -1) {
                destFileName.write(data, 0, count);
                System.out.printf("Save: %s \n",count);
            }
            destFileName.flush();
            dataPhoto.setPathPhoto(nameSaveFile.toString());
            dataPhotoDao.save(dataPhoto);
            destFileName.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public InputStream downloadFile(String nameFile) {
//        smb://192.168.143.1/public/0Rostov/photoBee/123244443_07.07.2022_ответственный
        SmbFileInputStream smbFileInputStream;
        byte[] buffer = null;
        try {
            System.out.println(pathUpload + "/" + nameFile);
            SmbFile smbFile = new SmbFile(pathUpload + "/" + nameFile);
            smbFileInputStream = new SmbFileInputStream(smbFile);
            buffer = new byte[(int) smbFile.length()];
            int bytesRead = 0;
            do {
                bytesRead = smbFileInputStream.read(buffer, 0 ,buffer.length);
                // here you have "bytesRead" in buffer array
                System.out.println(bytesRead);
                System.out.println("SMB file read:" + smbFileInputStream.available());
            }
            while (bytesRead != -1);
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (SmbException ex) {
            ex.printStackTrace();
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return new ByteArrayInputStream(buffer);
    }

    private void testSave(InputStream inputStream, byte[] bytes) {
        System.out.println();
        try {
            SmbFileOutputStream destFileName = new SmbFileOutputStream(
                    new SmbFile(pathUpload + "/test.png"));
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            byte data[] = new byte[1024];
            int count;
            while ((count = bufferedInputStream.read(data, 0, 1024)) != -1) {
                destFileName.write(data, 0, count);
            }
            destFileName.flush();
        } catch (SmbException ex) {
            ex.printStackTrace();
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
