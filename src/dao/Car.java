package dao;

import java.beans.ConstructorProperties;

/**
 * Created by Administrator on 2019/9/5 5:09.
 */
public class Car {
    private int price;
    private String owner;

    public void setPrice(int price) {
        this.price = price;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getPrice() {
        return price;
    }
    public String getOwner() {
        return owner;
    }

    public Car() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor1  *********");
        price = 0;
        owner = "xx";
    }

    @ConstructorProperties({"owner", "price"})
    public Car(int price, String owner) {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor2  *********");

        System.out.println("price is " + price);
        System.out.println("owner is " + owner);

        this.price = price;
        this.owner = owner;
    }
}
