package model;

import java.io.Serializable;

/**
 * Created by Iurii on 02.03.2016.
 */
public class Address  implements Serializable {
    private String street;
    private int houseNum;

    public Address( String city, String street, int houseNum) {
        this.street = street;
        this.houseNum = houseNum;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(int houseNum) {
        this.houseNum = houseNum;
    }

    public String asString() {
        return String.format("street:%s,houseNum:%d",
                street,houseNum);
    }
}
