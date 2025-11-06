package makeone;

public class PremiumCustomer extends Customer{
    private int rewardPoints;

    public PremiumCustomer(String name){
        super(name, "premium");
        this.rewardPoints = 0;
    }
    public void addPoints(double amount){
        rewardPoints += (int)(amount / 100);
    }
    public double applyDiscount(double total){
        int usablePoints = rewardPoints / 100;
        double discount = usablePoints * 10;
        rewardPoints -= usablePoints * 100;
        return total - discount;
    }
    public int getPoints(){ 
    	return rewardPoints;
    }
}
