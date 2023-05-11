package org.generation.foodhunters.controller.dto;

public class PostDTO {


        private String content;
        private String postDate;


    public PostDTO( String content, String postDate)

    {
        this.content = content;
        this.postDate = postDate;


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

}
