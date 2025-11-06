package makeone;
import java.util.*;

public class Sale {
    private List<SaleDetail> items = new ArrayList<>();
    private Customer customer;

    public Sale(Customer customer) {
        this.customer = customer;
    }

    public void addItem(Product product, int quantity) {
        if (product.getStock() < quantity) {
            System.out.println("Insufficient stock for " + product.getName());
            return;
        }
        product.updateStock(quantity, true);
        items.add(new SaleDetail(product, quantity));
    }
    public void printBill() {
        double total = 0, taxTotal = 0;
        System.out.println("\nSale Invoice");
        for (SaleDetail item : items) {
            double subtotal = item.getSubtotal();
            double tax = item.getTax();
            total += subtotal;
            taxTotal += tax;
            System.out.printf("%s x%d: ₹%.2f + Tax ₹%.2f\n",
                item.getProduct().getName(), item.getQuantity(), subtotal, tax);
        }
        double finalAmount = total + taxTotal;
        if (customer instanceof PremiumCustomer) {
            PremiumCustomer pc = (PremiumCustomer) customer;
            pc.addPoints(total);
            finalAmount = pc.applyDiscount(finalAmount);
            System.out.println("Reward points updated: " + pc.getPoints());
        }
        System.out.printf("Total Amount: ₹%.2f\n", finalAmount);
    }
}
