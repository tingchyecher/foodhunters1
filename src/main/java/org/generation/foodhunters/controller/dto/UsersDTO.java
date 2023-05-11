package org.generation.foodhunters.controller.dto;

public class UsersDTO {
    private String userName;
    private String email;
    private String profilePic;


    public UsersDTO(String  userName, String email, String profilePic  )
    {
        this.userName = userName;
        this.email = email;
        this.profilePic = profilePic;
    }


    public String getUserName()
    {
        return userName;
    }


    public void setUserName( String userName )
    {
        this.userName = userName;
    }


    public String getEmail()
    {
        return email;
    }


    public void setEmail( String email )
    {
        this.email = email;
    }


    public String getProfilePic()
    {
        return profilePic;
    }


    public void setProfilePic( String profilePic )
    {
        this.profilePic = profilePic;
    }


}

