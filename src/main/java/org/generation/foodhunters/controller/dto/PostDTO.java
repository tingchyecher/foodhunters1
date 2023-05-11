package org.generation.foodhunters.controller.dto;

public class PostDTO {


        private String content;
        private String postDate;
        private Integer idTopic;
    private Integer idUsers;


    public PostDTO( String content, String postDate, Integer idTopic, Integer idUsers)

    {
        this.content = content;
        this.postDate = postDate;
        this.idTopic = idTopic;
        this.idUsers = idUsers;

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public Integer getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(Integer idTopic) {
        this.idTopic = idTopic;
    }

    public Integer getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(Integer idUsers) {
        this.idUsers = idUsers;
    }
}
