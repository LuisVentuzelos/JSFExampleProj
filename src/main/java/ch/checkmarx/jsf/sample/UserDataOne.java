package ch.checkmarx.jsf.sample;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean(name = "UserDataMany", eager = true)
@SessionScoped
public class UserDataMany implements Serializable {
    private static final long serialVersionUID = 1L;
    public String[] data = {"1","2","3"};

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }
}