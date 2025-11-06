package makeone;

import java.util.*;

public class Main {
    static List<Product> products = new ArrayList<>();
    static List<Customer> customers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nInventory & Billing Menu");
            System.out.println("1. Add Product\n2. Add Customer\n3. Make Purchase\n4. Make Sale\n5. Display Products\n6. Display Customers\n0. Exit");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1 -> addProduct(sc);
                case 2 -> addCustomer(sc);
                case 3 -> makePurchase(sc);
                case 4 -> makeSale(sc);
                case 5 -> displayProducts();
                case 6 -> displayCustomers();
                case 0 -> System.exit(0);
                default -> System.out.println("Invalid choice.");
            }
        }
    }
    static void addProduct(Scanner sc) {
        System.out.print("Name: "); String name = sc.nextLine();
        System.out.print("Category: "); String cat = sc.nextLine();
        System.out.print("Price: "); double price = sc.nextDouble();
        System.out.print("Stock: "); int stock = sc.nextInt();
        products.add(new Product(name, cat, price, stock));
    }
    static void addCustomer(Scanner sc) {
        System.out.print("Name: "); String name = sc.nextLine();
        System.out.print("Type (regular/premium): "); String type = sc.nextLine();
        if (type.equalsIgnoreCase("premium"))
            customers.add(new PremiumCustomer(name));
        else
            customers.add(new Customer(name, type));
    }
    static void makeSale(Scanner sc) {
        System.out.print("Customer name: "); String cname = sc.nextLine();
        Customer cust = customers.stream().filter(c -> c.getName().equalsIgnoreCase(cname)).findFirst().orElse(null);
        if (cust == null) { System.out.println("Customer not found."); return; }

        Sale sale = new Sale(cust);
        while (true) {
            System.out.print("Product name (or 'done'): "); String pname = sc.nextLine();
            if (pname.equalsIgnoreCase("done")) break;
            Product prod = products.stream().filter(p -> p.getName().equalsIgnoreCase(pname)).findFirst().orElse(null);
            if (prod == null) { System.out.println("Product not found."); continue; }
            System.out.print("Quantity: "); int qty = sc.nextInt(); sc.nextLine();
            sale.addItem(prod, qty);
        }
        sale.printBill();
    }
    static void makePurchase(Scanner sc) {
        System.out.print("Product name: "); String pname = sc.nextLine();
        Product prod = products.stream().filter(p -> p.getName().equalsIgnoreCase(pname)).findFirst().orElse(null);
        if (prod == null) { System.out.println("Product not found."); return; }
        System.out.print("Quantity: "); int qty = sc.nextInt(); sc.nextLine();
        prod.updateStock(qty, false);
        System.out.println("Stock updated.");
    }
    static void displayProducts() {
        System.out.println("\nProduct List");
        for (Product p : products)
            System.out.printf("%s (%s): ₹%.2f, Stock: %d\n", p.getName(), p.getCategory(), p.getPrice(), p.getStock());
    }
    static void displayCustomers() {
        System.out.println("\nCustomer List");
        for (Customer c : customers)
            System.out.printf("%s [%s]\n", c.getName(), c.isPremium() ? "Premium" : "Regular");
    }
}
