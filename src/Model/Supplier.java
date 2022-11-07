package Model;

import Model.Rules.Validation;

public class Supplier implements Validation{
    private int id;
    private String name;
    private String contact;
    private String country;
    private String email;
    private int country_cod;
    private int nuit;
    private String cep;
    private String produt_type;
    private String address;
    private String updated_at;
    private String created_at;

    public Supplier() {
    }

    public Supplier(int id, String name, String contact, String country,
            String email, int country_cod, int nuit, String cep,
            String produt_type, String address, String updated_at,
            String created_at) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.country = country;
        this.email = email;
        this.country_cod = country_cod;
        this.nuit = nuit;
        this.cep = cep;
        this.produt_type = produt_type;
        this.address = address;
        this.updated_at = updated_at;
        this.created_at = created_at;
    }

    public Supplier(String name, String contact, String country,
            String email, int country_cod, int nuit, String cep,
            String produt_type, String address) {
        this.name = name;
        this.contact = contact;
        this.country = country;
        this.email = email;
        this.country_cod = country_cod;
        this.nuit = nuit;
        this.cep = cep;
        this.produt_type = produt_type;
        this.address = address;
    }

    public Supplier(int id, String name, String contact, String country,
            String email, int country_cod, int nuit, String cep,
            String produt_type, String address) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.country = country;
        this.email = email;
        this.country_cod = country_cod;
        this.nuit = nuit;
        this.cep = cep;
        this.produt_type = produt_type;
        this.address = address;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCountry_cod() {
        return country_cod;
    }

    public void setCountry_cod(int country_cod) {
        this.country_cod = country_cod;
    }

    public int getNuit() {
        return nuit;
    }

    public void setNuit(int nuit) {
        this.nuit = nuit;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getProdut_type() {
        return produt_type;
    }

    public void setProdut_type(String produt_type) {
        this.produt_type = produt_type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
    
    
    public boolean[] validation(){
        boolean[] errors = new boolean[3];
        
        return errors;
    }
    
    
    
    
    
    
    

    @Override
    public boolean minSize(String text, int size) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean maxSize(String text, int size) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEqual(String text1, String text2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean minMaxSize(String text, int minSize, int maxSize) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isNull(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
