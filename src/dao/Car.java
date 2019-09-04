package dao;

import java.beans.ConstructorProperties;

/**
 * Created by Administrator on 2019/9/5 5:09.
 */
public class Car {
    int price = 0;
    String owner = "xx";

    public int getPrice() {
        return price;
    }

    public String getOwner() {
        return owner;
    }

    @ConstructorProperties({"age", "name"})
    public Car(int price, String owner) {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");

        System.out.println("price is " + price);
        System.out.println("owner is " + owner);

        this.price = price;
        this.owner = owner;
    }
}
