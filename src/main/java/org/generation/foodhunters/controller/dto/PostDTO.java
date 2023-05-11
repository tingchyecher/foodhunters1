package org.generation.foodhunters.controller.dto;

public class PostDTO {

        private Integer idPost;
        private String content;
        private String postDate;
        private String idTopic;
        private String idUsers;

    public PostDTO(Integer idPost, String content, String postDate, String idTopic, String idUsers)

    {
        this.content = content;
        this.postDate = postDate;
        this.idTopic = idTopic;
        this.idUsers = idUsers;

    }

    public Integer getIdPost() {
        return idPost;
    }

    public void setIdPost(Integer idPost) {
        this.idPost = idPost;
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

    public String getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(String idTopic) {
        this.idTopic = idTopic;
    }

    public String getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(String idUsers) {
        this.idUsers = idUsers;
    }
}
