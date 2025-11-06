package makeone;

public class ProductTaxCategory {
    public static double getTaxRate(String category) {
        switch (category.toLowerCase()) {
            case "electronics": return 0.18;
            case "clothing": return 0.12;
            default: return 0.05;
        }
    }
}
