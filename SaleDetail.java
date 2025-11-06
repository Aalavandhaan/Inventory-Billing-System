package makeone;

public class SaleDetail {
    private Product product;
    private int quantity;

    public SaleDetail(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    public double getSubtotal() {
        return product.getPrice() * quantity;
    }
    public double getTax() {
        return getSubtotal() * ProductTaxCategory.getTaxRate(product.getCategory());
    }
    public int getQuantity() { 
    	return quantity; 
    }
    public Product getProduct() { 
    	return product; 
    }
}
