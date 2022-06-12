package photoBalans.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "beef", schema = "public", catalog = "photoBee")
public class BeeF {
    @Id
    @GeneratedValue(generator= "beef_seq")
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTpAndLine() {
        return tpAndLine;
    }

    public void setTpAndLine(String tp_and_line) {
        this.tpAndLine = tp_and_line;
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

    @Override
    public String toString() {
        return "BeeF{" +
                "id=" + id +
                ", tp_and_line='" + tpAndLine + '\'' +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", numberAccount='" + numberAccount + '\'' +
                ", nameDevice='" + nameDevice + '\'' +
                ", numberDevice='" + numberDevice + '\'' +
                ", house='" + house + '\'' +
                ", values='" + values + '\'' +
                ", date=" + date +
                ", res='" + res + '\'' +
                '}';
    }
}
