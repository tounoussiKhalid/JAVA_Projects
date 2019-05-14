
package models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Log {
    
    
    private SimpleIntegerProperty  id_operation;
    private SimpleIntegerProperty  id_maker;
    private SimpleStringProperty  operation;
    private  SimpleStringProperty  date_register;    
    private SimpleIntegerProperty num;
     
    public Log(int id_operation,int  num, String operation, String date_register, int id_maker) {
        this.num =  new SimpleIntegerProperty(num);
        this.id_operation =  new SimpleIntegerProperty(id_operation);
        this.id_maker =  new SimpleIntegerProperty(id_maker);
        this.operation = new SimpleStringProperty(operation);
        this.date_register = new SimpleStringProperty(date_register);
    }

    public  int getNum() {
        return num.get();
    }

    public  void setNum(int num) {
       this.num =  new SimpleIntegerProperty(num);
    }

    
    public int getId_operation() {
        return id_operation.get();
    }

    public void setId_operation(int id_operation) {
        this.id_operation =  new SimpleIntegerProperty(id_operation);
    }

    public int getId_maker() {
        return id_maker.get();
    }

    public void setId_maker(int id_maker) {
        this.id_maker =  new SimpleIntegerProperty(id_maker);
    }

    public String getOperation() {
        return operation.get();
    }

    public void setOperation(String operation) {
        this.operation = new SimpleStringProperty(operation);
    }

    public String getDate_register() {
        return date_register.get();
    }

    public void setDate_register(String date_register) {
        this.date_register = new SimpleStringProperty(date_register);
    }
     
     
     
    
}
