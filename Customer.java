package makeone;

public class Customer {
    protected String name,type;

    public Customer(String name, String type) {
        this.name = name;
        this.type = type;
    }
    public boolean isPremium(){
        return type.equalsIgnoreCase("premium");
    }
    public String getName(){ 
    	return name; 
    }
}
