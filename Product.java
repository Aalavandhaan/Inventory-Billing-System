package makeone;

public class Product {
    private String name,category;
    private double price;
    private int stock;

    public Product(String name, String category, double price, int stock) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }
    public void updateStock(int quantity, boolean isSale) {
        stock += isSale ? -quantity : quantity;
    }
    public int getStock(){
    	return stock;
    }
    public double getPrice(){
    	return price; 
    }
    public String getName(){
    	return name; 
    }
    public String getCategory(){
    	return category; 
    }
}
