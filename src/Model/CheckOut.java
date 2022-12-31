package Model;

public class CheckOut {
    private int id;
    private int prod_id;
    private double amount;
    private String prod_name;
    private int driver_id;
    private int store_id;
    private int user_id;
    private String username;
    private String store;
    private String driver_name;
    private String created_at;
    private String updated_at;

    public CheckOut() {
    }
    
    
    
    public CheckOut(int id, int prod_id, int driver_id, int user_id,
            String username, String driver_name, double amount,
             String prod_name,
            String created_at, int store_id, String store) {
        this.id = id;
        this.prod_id = prod_id;
        this.driver_id = driver_id;
        this.user_id = user_id;
        this.username = username;
        this.driver_name = driver_name;
        this.amount = amount;
        this.prod_name = prod_name;
        this.created_at = created_at;
        this.store_id = store_id;
        this.store = store;
    }

    public CheckOut(int prod_id, double amount, int driver_id, int store_id,
            int user_id) {
        this.prod_id = prod_id;
        this.amount = amount;
        this.driver_id = driver_id;
        this.store_id = store_id;
        this.user_id = user_id;
    }
    
    

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }
    
    
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public int getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(int driver_id) {
        this.driver_id = driver_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
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
