package Model;
public class Product {
    private int id;
    private String name;
    private double amount;
    private double available_amount;
    private String unity;
    private double damaged;
    private String category;
    private String supplier;
    private int supplier_id;
    private String driver;
    private int driver_id;
    private String created_at;
    private String updated_at;
    
    
    public Product(){
        
    }

    public Product(int id, String name, double amount, String unity, double damaged, String created_at, String updated_at) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.unity = unity;
        this.damaged = damaged;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Product(int id, String name, double amount, String unity,
            String supplier, int supplier_id) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.unity = unity;
        this.supplier = supplier;
        this.supplier_id = supplier_id;
    }

    
    public Product(String name, double amount, String unity) {
        this.name = name;
        this.amount = amount;
        this.unity = unity;
    }

    public Product(String name, double amount, String unity, String category,
            int supplier_id) {
        this.name = name;
        this.amount = amount;
        this.unity = unity;
        this.category = category;
        this.supplier_id = supplier_id;
    }
    
    public Product(String name, double amount, String unity, String category,
            int supplier_id, double available_amount) {
        this.name = name;
        this.amount = amount;
        this.unity = unity;
        this.category = category;
        this.supplier_id = supplier_id;
        this.available_amount = available_amount;
    }
    
    public Product(int id, String name, double amount, String unity, String category,
            int supplier_id, double available_amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.unity = unity;
        this.category = category;
        this.supplier_id = supplier_id;
        this.available_amount = available_amount;
    }
    
    

    public double getAvailable_amount() {
        return available_amount;
    }

//    public Product(String name, double amount, String unity, double damaged) {
//        this.name = name;
//        this.amount = amount;
//        this.unity = unity;
//        this.damaged = damaged;
//    }
    public void setAvailable_amount(double available_amount) {
        this.available_amount = available_amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public int getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(int driver_id) {
        this.driver_id = driver_id;
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
