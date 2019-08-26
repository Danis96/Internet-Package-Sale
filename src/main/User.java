/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/*
 *
 * @author Vedo
 */
public class User {
     private final StringProperty firstName = new SimpleStringProperty(this, "firstName", "");
    private final StringProperty lastName = new SimpleStringProperty(this, "lastName", "");
    private final StringProperty adresa = new SimpleStringProperty(this, "adresa");
    private final StringProperty brzina = new SimpleStringProperty(this,"brzina");  
    private final StringProperty protok = new SimpleStringProperty(this,"protok");  
    private final StringProperty ugovor = new SimpleStringProperty(this,"ugovor");  

    public User()
    {

    }

    public User(String firstName, String lastName, String adresa,String brzina,String protok,String ugovor)
    {
	this.firstName.set(firstName);
	this.lastName.set(lastName);
	this.adresa.set(adresa);
        this.brzina.set(brzina);
	this.protok.set(protok);
	this.ugovor.set(ugovor);
	
    }

    public User(String firstName)
    {
	this.firstName.set(firstName);
    }

    public User(String firstName, String lastName)
    {
	this.firstName.set(firstName);
	this.lastName.set(lastName);
    }

    public String getFirstName()
    {
	return firstName.get();
    }

    public void setFirstName(String firstName)
    {
	this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty()
    {
	return firstName;
    }

    public String getLastName()
    {
	return lastName.get();
    }

    public void setLastName(String lastName)
    {
	this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty()
    {
	return lastName;
    }

    public String getAdresa()
    {
	return adresa.get();
    }

    public void setAdresa(String adresa)
    {
	this.adresa.set(adresa);
    }

    public StringProperty adresaProperty()
    {
	return adresa;
    }

    public String getBrzina() {return brzina.get();}  
    public void setBrzina(String brzina) {this.brzina.set(brzina);}  
    public StringProperty brzinaProperty() {return brzina;}  
      
    public String getProtok() {return protok.get();}  
    public void setProtok(String protok) {this.protok.set(protok);}  
    public StringProperty protokProperty() {return protok;}  
      
    public String getUgovor() {return ugovor.get();}  
    public void setUgovor(String ugovor) {this.ugovor.set(ugovor);}  
    public StringProperty ugovorProperty() {return ugovor;}  

    

    private final ObjectProperty<ArrayList<String>> errorList = new SimpleObjectProperty<>(this, "errorList", new ArrayList<>());

    public ObjectProperty<ArrayList<String>> errorsProperty()
    {
	return errorList;
    }

    public boolean isValid()
    {
	boolean isValid = true;
	if(firstName.get() != null && firstName.get().equals(""))
	{
	    errorList.getValue().add("First name can't be empty!");
	    isValid = false;
	}
	if(lastName.get().equals(""))
	{
	    errorList.getValue().add("Last name can't be empty!");
	    isValid = false;
	}
	if(adresa.get().equals(""))
	{
	    errorList.getValue().add("Adress can't be empty!");
	    isValid = false;
	}
        if(brzina.get().equals(""))
	{
	    errorList.getValue().add("Brzina can't be empty!");
	    isValid = false;
	}
        if(protok.get().equals(""))
	{
	    errorList.getValue().add("Protok can't be empty!");
	    isValid = false;
	}
        if(ugovor.get().equals(""))
	{
	    errorList.getValue().add("Ugovor can't be empty!");
	    isValid = false;
	}
	return isValid;
    }
    
}
