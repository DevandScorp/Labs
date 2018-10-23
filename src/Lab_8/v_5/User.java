package Lab_8.v_5;

import java.io.Serializable;
import java.lang.reflect.Field;
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
    private static String field = "name";
    public static String getFieldVal(){
        return field;
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
