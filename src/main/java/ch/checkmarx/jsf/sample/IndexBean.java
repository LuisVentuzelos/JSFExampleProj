package ch.checkmarx.jsf.sample;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ch.checkmarx.jsf.sample.User;

@ManagedBean
@SessionScoped
public class IndexBean {
    private String username;
    private String password;
    private String email;
    private boolean registered;
    private List<User> users = new ArrayList<User>();
    private User registeredUser;

    public IndexBean(){
        User user = new User();
        user.setUsername("Test1");
        user.setPassword("test!@#");
        user.setEmail("test.one@test.com");
        this.users.add(user);
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
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

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getRegisteredUser() {
        return registeredUser;
    }

    public void setRegisteredUser(User registeredUser) {
        this.registeredUser = registeredUser;
    }

    public String login(){
        // Do some processing
        for(User u : this.users){
            if(this.username.equalsIgnoreCase(u.getUsername()) && this.password.equals(u.getPassword())){
                this.registered = true;
                this.registeredUser = u;
                return "success";
            }
        }
        if(this.registeredUser == null){
            this.registeredUser = new User();
            this.registeredUser.setUsername(this.username);
            this.registeredUser.setPassword(this.password);
            this.registeredUser.setEmail("");
            this.users.add(registeredUser);
            this.registered = false;
            return "failed";
        }
        return "failed";
    }

    public String logout(){
        this.registeredUser = null;
        return "index";
    }
}