package Model;

import java.sql.Date;

public class CheckIn {
    private int id;
    private int prod_id;
    private int driver_id;
    private int user_id;
    private String username;
    private String driver_name;
    private double amount;
    private double available_amount;
    private String prod_name;
    private double price;
    private String expire_date;
    private String created_at;
    private String updated_at;

    public CheckIn(int prod_id, int driver_id, double amount,
            double available_amount, double price, String expire_date) {
        this.prod_id = prod_id;
        this.driver_id = driver_id;
        this.amount = amount;
        this.available_amount = available_amount;
        this.price = price;
        this.expire_date = expire_date;
    }

    public CheckIn() {
    }



    
    
    
    
    
    public String getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(String expire_date) {
        this.expire_date = expire_date;
    }
    
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public double getAvailable_amount() {
        return available_amount;
    }

    public void setAvailable_amount(double available_amount) {
        this.available_amount = available_amount;
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
