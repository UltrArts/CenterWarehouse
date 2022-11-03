package Model;

public class Person {
    private int id;
    private String bi;
    private String name;
    private String lastname;
    private String adress;
    private String contact;
    private String created_at;
    private String updated_at;

    
    public Person(){
        
    }

    public Person(int id, String name, String lastname) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
    }
    
    

    public Person(String bi, String name, String lastname, String adress, String contact) {
        this.bi = bi;
        this.name = name;
        this.lastname = lastname;
        this.adress = adress;
        this.contact = contact;
    }

    public Person(int id, String bi, String name, String lastname, String adress,
            String contact, String created_at, String updated_at) {
        this.id = id;
        this.bi = bi;
        this.name = name;
        this.lastname = lastname;
        this.adress = adress;
        this.contact = contact;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
    
    

   
    
  
    public String getBi() {
        return bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
