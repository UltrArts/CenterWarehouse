package Model;
public class Product {
    private int id;
    private String name;
    private double amount;
    private String unity;
    private String details;
    private double damaged;
    private String created_at;
    private String updated_at;
    
    
    public Product(){
        
    }

    public Product(int id, String name, double amount, String unity, String details, double damaged, String created_at, String updated_at) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.unity = unity;
        this.details = details;
        this.damaged = damaged;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Product(String name, double amount, String unity, String details) {
        this.name = name;
        this.amount = amount;
        this.unity = unity;
        this.details = details;
    }

    public Product(String name, double amount, String unity, String details, double damaged) {
        this.name = name;
        this.amount = amount;
        this.unity = unity;
        this.details = details;
        this.damaged = damaged;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getUnity() {
        return unity;
    }

    public void setUnity(String unity) {
        this.unity = unity;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public double getDamaged() {
        return damaged;
    }

    public void setDamaged(double damaged) {
        this.damaged = damaged;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
    
    
}
