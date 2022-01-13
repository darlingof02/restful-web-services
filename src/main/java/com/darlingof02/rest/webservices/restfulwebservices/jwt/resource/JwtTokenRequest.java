package com.darlingof02.rest.webservices.restfulwebservices.jwt.resource;

import java.io.Serializable;

public class  JwtTokenRequest implements Serializable {

    private static final long serialVersionUID = -5616176897013108345L;

//    {
//        "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJpbjI4bWludXRlcyIsImV4cCI6MTY0MTI1Njk0OSwiaWF0IjoxNjQwNjUyMTQ5fQ.30wlGk-Sfr2cy0hd3ID4tHR6VeiBWEAyDNP1UTX6ntoQfX_7-p2H2hvJSoECdWTiqrtCkAXd4Fiyu4iX9ihQBw"
//    }


    private String username;
    private String password;

    public JwtTokenRequest() {
        super();
    }

    public JwtTokenRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

