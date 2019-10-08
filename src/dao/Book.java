package dao;

import java.beans.ConstructorProperties;

/**
 * Created by Administrator on 2019/9/5 5:09.
 */
public class Book {
    private int price;
    private String owner;

    @Override
    public String toString() {
        return "Book{" +
                "price=" + price +
                ", owner='" + owner + '\'' +
                '}';
    }

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

    public Book() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor1  *********");
        price = 0;
        owner = "xx";
    }
}
