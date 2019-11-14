package vn.edu.uit.tmlnghia.shopping.models;

public class ShoppingCartItemDetail {

    private String name;
    private String seller;
    private int image;
    private int price;
    private int numberOfItem;



    public ShoppingCartItemDetail(){

    }

    public ShoppingCartItemDetail(String name, String seller, int image, int price, int numberOfItem) {
        this.name = name;
        this.seller = seller;
        this.image = image;
        this.price = price;
        this.numberOfItem = numberOfItem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumberOfItem() {
        return numberOfItem;
    }

    public void setNumberOfItem(int numberOfItem) {
        this.numberOfItem = numberOfItem;
    }
}
