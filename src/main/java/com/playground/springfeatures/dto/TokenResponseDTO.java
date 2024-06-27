package com.playground.springfeatures.dto;



//@JsonIgnoreProperties(ignoreUnknown = true)  //if we want to ignore the
public class TokenResponseDTO {
    private String token;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "TokenResponseDTO{" +
                "token='" + token + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
