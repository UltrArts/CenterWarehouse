package Model;

import Model.Rules.Validation;
import Model.Rules.ValidationActionType;
import javax.swing.JPanel;

public class User extends Person implements Validation{
    
    private String username;
    private String password;
    private String profile;
    private boolean status;
    
    public User(){
        
    }

    public User(String username, String password, int id, String name, String lastname) {
        super(id, name, lastname);
        this.username = username;
        this.password = password;
    }
    

    public User(String username, String password,  String bi, String name, String lastname, String adress, String contact, String profile) {
        super(bi, name, lastname, adress, contact);
        this.username = username;
        this.password = password;
        this.profile = profile;
    }

    public User(String username, String password,  String bi, String name, String lastname, String adress, String contact) {
        super(bi, name, lastname, adress, contact);
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, int id, String bi, String name,
            String lastname, String adress, String contact, String profile, Boolean status, String created_at,
            String updated_at) {
        super(id, bi, name, lastname, adress, contact, created_at, updated_at);
        this.username = username;
        this.password = password;
        this.profile = profile;
        this.status = status;
    }
    
    public User( int id, String bi, String name,
            String lastname, String adress, String contact, String profile) {
        super(id, bi, name, lastname, adress, contact);
        this.profile = profile;
    }
    
    

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setUpdated_at(String updated_at) {
        super.setUpdated_at(updated_at); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getUpdated_at() {
        return super.getUpdated_at(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCreated_at(String created_at) {
        super.setCreated_at(created_at); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCreated_at() {
        return super.getCreated_at(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setContact(String contact) {
        super.setContact(contact); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getContact() {
        return super.getContact(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAdress(String adress) {
        super.setAdress(adress); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAdress() {
        return super.getAdress(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLastname(String lastname) {
        super.setLastname(lastname); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getLastname() {
        return super.getLastname(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setName(String name) {
        super.setName(name); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        return super.getName(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setBi(String bi) {
        super.setBi(bi); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getBi() {
        return super.getBi(); //To change body of generated methods, choose Tools | Templates.
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
    
    public boolean[] validation(User us){
        boolean[] error = new boolean[6];
        if(minMaxSize(us.getName(), 2, 60))
            error[0] = true;

        if(minMaxSize(us.getLastname(), 2, 30))
            error[1] = true;

        if(minMaxSize(us.getBi(), 13, 13))
            error[2] = true;
        
        if(minMaxSize(us.getContact(), 5, 13))
            error[3] = true;

        if(minSize(us.getAdress(), 5))
            error[4] = true;
        
        if(minMaxSize(us.getUsername(), 4, 15))
            error[5] = true;

        
        return error;
    }

    @Override
    public boolean minSize(String text, int size) {
        if(isNull(text))
            return text.length() >= size;
        return false;
    }

    @Override
    public boolean maxSize(String text, int size) {
        if(isNull(text))
            return text.length() <= size;
        return false;
    }

    @Override
    public boolean isEqual(String text1, String text2) {
        if(isNull(text1) && isNull(text2))
            return text1.equals(text2);
        return false;
    }

    @Override
    public boolean minMaxSize(String text, int minSize, int maxSize) {
        if(isNull(text))
            return minSize(text, minSize) && maxSize(text, maxSize);
        return false;
    }

    @Override
    public boolean isNull(String text) {
        return text != null;
    }

    
    
}
