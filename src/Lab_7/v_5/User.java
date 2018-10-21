package Lab_7.v_5;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private String name;
    private String surname;
    private String patronymic;
    private String phone;
    private String area;
    private String address;
    private long dealNumber;
    private Date dealDate;
    private long userPay;
    private Date lastPay;

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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
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
}
