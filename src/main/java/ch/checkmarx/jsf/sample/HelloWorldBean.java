package ch.checkmarx.jsf.sample;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import java.io.Serializable;

@ManagedBean(name = "helloBean", eager = true)
@SessionScoped
public class HelloWorldBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSayWelcome(){
        //check if null?
        if("".equals(name) || name ==null){
            return "";
        }else{
            return "Ajax message : Welcome " + name;
        }
    }

    public String showResult() {
        return "result1";
    }

    public void updateData(ActionEvent e) {
        name="Hello Developer";
    }
}