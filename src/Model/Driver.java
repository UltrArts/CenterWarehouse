package Model;

public class Driver extends Person{
    private String matricula;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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
    
}
