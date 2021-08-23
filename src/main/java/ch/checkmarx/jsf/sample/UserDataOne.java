package ch.checkmarx.jsf.sample;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean(name = "UserDataOne", eager = true)
@SessionScoped
public class UserDataOne implements Serializable {
    private static final long serialVersionUID = 1L;
    public String data = "1";

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}