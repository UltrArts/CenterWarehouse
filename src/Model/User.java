package Model;

public class User extends Person{
    
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
    
    
}
