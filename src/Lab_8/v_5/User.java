package Lab_8.v_5;

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
    private static int index = 0;
    public static void setIndex(int index1){
        if(index1<0 || index1>9){
            System.out.println("Wrong index");
            System.exit(0);
        }
        index = index1;
    }
    public Object getField(){
        switch(index){
            case 0:
                return this.name;
            case 1:
                return this.surname;
            case 2:
                return this.patronymic;
            case 3:
                return this.phone;
            case 4:
                return this.area;
            case 5:
                return this.address;
            case 6:
                return this.dealNumber;
            case 7:
                return this.dealDate;
            case 8:
                return this.userPay;
            case 9:
                return this.lastPay;
            default:
                return null;
        }
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
