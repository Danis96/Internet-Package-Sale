/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author Vedo
 */
public class UserController {
     @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField adresa;
    @FXML  
    private ChoiceBox<String> cbBrzina;  
   @FXML  
    private ChoiceBox<String> cbProtok;  
    @FXML  
    private ChoiceBox<String> cbUgovor;  
    @FXML
    private Button saveBtn;
    @FXML
    private Button clearBtn;
    @FXML
    private Button closeBtn;
    @FXML
    private Button deleteBtn;

    @FXML
    private URL location;
    @FXML
    private ResourceBundle resources;

    ObservableList<User> persons = FXCollections.<User>observableArrayList();
    User person;

    @FXML//
    TableView<User> tabela = new TableView<>();//

    public UserController()
    {
    }

    @FXML
    private void initialize()
    {
	person = new User();

	firstName.textProperty().bindBidirectional(person.firstNameProperty());
	lastName.textProperty().bindBidirectional(person.lastNameProperty());
	adresa.textProperty().bindBidirectional(person.adresaProperty());
cbBrzina.valueProperty().bindBidirectional(person.brzinaProperty());
cbProtok.valueProperty().bindBidirectional(person.protokProperty());
 cbUgovor.valueProperty().bindBidirectional(person.ugovorProperty()); 
	


cbBrzina.getItems().addAll("2", "5", "10", "20", "50", "100"); 
 cbProtok.getItems().addAll("1", "5", "10", "100", "Flat"); 
 cbUgovor.getItems().addAll("1", "2");
    }

    @FXML
    private void savePerson()
    {
	
	   
	    persons = tabela.getItems();
	    persons.add(new User(firstName.getText(), lastName.getText(), adresa.getText(),cbBrzina.getSelectionModel().getSelectedItem(),cbProtok.getSelectionModel().getSelectedItem(),cbUgovor.getSelectionModel().getSelectedItem()));
	    tabela.setItems(persons);
	 
	
    }

    @FXML
    private void closeForm()
    {
	Platform.exit();
    }

    @FXML
    private void clearPerson()
    {
        
          person.brzinaProperty().set("");
	person.protokProperty().set("");
	person.ugovorProperty().set("");
	person.firstNameProperty().set("");
	person.lastNameProperty().set("");
	person.adresaProperty().set("");
      
	
	
    }

   
    @FXML
    private void deletePerson()
    {
        
        persons = tabela.getItems();
        int index = tabela.selectionModelProperty().getValue().getSelectedIndex();
        if (index !=-1) {
            
	
	persons.remove(index);
	tabela.setItems(persons);
        }
        else{
        
                StringBuilder errMsg = new StringBuilder();

	    ArrayList<String> errList = person.errorsProperty().get();
	    for(String errList1 : errList)
		errMsg.append(errList1);

	    Alert alert = new Alert(Alert.AlertType.ERROR);
	    alert.setTitle("Error!");
	    alert.setHeaderText("Empty file can't be deleted!");
	    alert.setContentText(errMsg.toString());
	    alert.showAndWait();
	    errList.clear();
        
        }
            
       
        
	
    }
    
}
