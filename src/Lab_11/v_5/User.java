package Lab_11.v_5;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

public class User implements Serializable {
    private boolean deleted = false;
    private String name;
    private String surname;
    private String patronymic;
    private String phone;
    private String area;
    private String address;
    private Long dealNumber;
    private Date dealDate;
    private Long userPay;
    private Date lastPay;
    private static String field = "name";
    public static String getFieldVal(){
        return field;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getDealNumber() {
        return dealNumber;
    }

    public void setDealNumber(Long dealNumber) {
        this.dealNumber = dealNumber;
    }

    public Date getDealDate() {
        return dealDate;
    }

    public void setDealDate(Date dealDate) {
        this.dealDate = dealDate;
    }

    public Long getUserPay() {
        return userPay;
    }

    public void setUserPay(Long userPay) {
        this.userPay = userPay;
    }

    public Date getLastPay() {
        return lastPay;
    }

    public void setLastPay(Date lastPay) {
        this.lastPay = lastPay;
    }

    @Override
    public String toString() {
        return "User{" +
                " name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", phone='" + phone + '\'' +
                ", area='" + area + '\'' +
                ", address='" + address + '\'' +
                ", dealNumber=" + dealNumber +
                ", dealDate=" + dealDate +
                ", userPay=" + userPay +
                ", lastPay=" + lastPay +
                '}';
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public static void setField(String field1) {
        field = field1;
    }

    public Object getField() throws IllegalAccessException, NoSuchFieldException {
        Field f = this.getClass().getDeclaredField(field);
        f.setAccessible(true);
        return f.get(this);
    }

    public User(String name, String surname, String patronymic, String phone, String area, String address, long dealNumber, Date dealDate, long userPay, Date lastPay) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.phone = phone;
        this.area = area;
        this.address = address;
        this.dealNumber = dealNumber;
        this.dealDate = dealDate;
        this.userPay = userPay;
        this.lastPay = lastPay;
    }

}
