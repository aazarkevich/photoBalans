package photoBalans.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "data_photo", schema = "public", catalog = "photoBee")
public class DataPhoto {
    @Id
    @GeneratedValue(generator = "data_photo_seq")
    private long id;
    @Basic
    @Column(name = "tp_and_line")
    private String tpAndLine;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "number_account")
    private String numberAccount;
    @Basic
    @Column(name = "name_device")
    private String nameDevice;
    @Basic
    @Column(name = "number_device")
    private String numberDevice;
    @Basic
    @Column(name = "house")
    private String house;
    @Basic
    @Column(name = "values")
    private String values;
    @Basic
    @Column(name = "date")
    private Date date;
    @Basic
    @Column(name = "res")
    private String res;
    @Basic
    @Column(name = "path_photo")
    private String pathPhoto;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTpAndLine() {
        return tpAndLine;
    }

    public void setTpAndLine(String tpAndLine) {
        this.tpAndLine = tpAndLine;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }

    public String getNameDevice() {
        return nameDevice;
    }

    public void setNameDevice(String nameDevice) {
        this.nameDevice = nameDevice;
    }

    public String getNumberDevice() {
        return numberDevice;
    }

    public void setNumberDevice(String numberDevice) {
        this.numberDevice = numberDevice;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public String getPathPhoto() {
        return pathPhoto;
    }

    public void setPathPhoto(String pathPhoto) {
        this.pathPhoto = pathPhoto;
    }

    @Override
    public String toString() {
        return "DataPhoto{" +
                "id=" + id +
                ", tpAndLine='" + tpAndLine + '\'' +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", numberAccount='" + numberAccount + '\'' +
                ", nameDevice='" + nameDevice + '\'' +
                ", numberDevice='" + numberDevice + '\'' +
                ", house='" + house + '\'' +
                ", values='" + values + '\'' +
                ", date=" + date +
                ", res='" + res + '\'' +
                ", pathPhoto=" + pathPhoto +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataPhoto dataPhoto = (DataPhoto) o;
        return Objects.equals(tpAndLine, dataPhoto.tpAndLine) &&
                Objects.equals(address, dataPhoto.address) &&
                Objects.equals(name, dataPhoto.name) &&
                Objects.equals(numberAccount, dataPhoto.numberAccount) &&
                Objects.equals(nameDevice, dataPhoto.nameDevice) &&
                Objects.equals(numberDevice, dataPhoto.numberDevice) &&
                Objects.equals(house, dataPhoto.house) &&
                Objects.equals(res, dataPhoto.res);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tpAndLine, address, name, numberAccount, nameDevice, numberDevice, house, res);
    }
}
