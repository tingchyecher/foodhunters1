package org.generation.foodhunters.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.generation.foodhunters.controller.dto.UsersDTO;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsers;             //retrieve product item by ID - has to be an object
    private String userName;
    private String email;
    private String profilePic;

    //Item Class is used to map within the Database table
    //Any CRUD operation, JPA will make use of this Item Clas to map
    //Even for Read operation

    //Constructor Overloading
    public Users() {}

    //*- DTO
    public Users(UsersDTO usersDTO)
    {
        //Transfer the object (with the data) to Entity Class for mapping with the
        // database table columns and to be able to save the data in the columns
        this.userName = usersDTO.getUserName();
        this.email = usersDTO.getEmail();
        this.profilePic = usersDTO.getProfilePic();

    }


    public Integer getId()
    {
        return idUsers;
    }


    public void setId( Integer idUsers )
    {
        this.idUsers = idUsers;
    }


    public String getUserName()
    {
        return userName;
    }


    public void setUsername( String userName)
    {
        this.userName = userName;
    }


    public String getEmail() { return email; }


    public void setEmail( String email)
    {
        this.email = email;
    }


    public String getProfilePic() { return profilePic; }


    public void setProfilePic( String profilePic)
    {
        this.profilePic = profilePic;
    }
}
