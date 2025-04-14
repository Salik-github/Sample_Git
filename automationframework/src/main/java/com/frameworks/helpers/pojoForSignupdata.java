package com.frameworks.helpers;

public class pojoForSignupdata {
    private String firstname;
    private String lastname;
    private String usertype;
    private String company_name;
    private String email;
    private String password;

    public pojoForSignupdata()
    {
        
    }
    public pojoForSignupdata(String firstname, String lastname, String usertype,
            String email, String password) {
                this.firstname= firstname;
                this.lastname=lastname;
                this.usertype = usertype;
                this.email = email;
                this.password = password;
    }

    public pojoForSignupdata(String firstname, String lastname, String usertype,String company_name,
    String email, String password) {
        this.firstname= firstname;
        this.lastname=lastname;
        this.usertype = usertype;
        this.company_name = company_name;
        this.email = email;
        this.password = password;
}

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }
    public String getCompany_name() {
        return company_name;
    }
    public  String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUsertype() {
        return usertype;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
  

}
