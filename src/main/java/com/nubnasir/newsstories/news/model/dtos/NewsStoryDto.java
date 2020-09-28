package com.nubnasir.newsstories.news.model.dtos;

import com.nubnasir.newsstories.user.model.dto.UserDto;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class NewsStoryDto {

    private long id;

    @NotEmpty(message = "Title is required")
    @Size(min = 4, max = 200, message = "Title length must be between 4 to 200 characters")
    private String title;

    @NotEmpty(message = "Content Body is required")
    @Size(min = 4, max = 200, message = "Title length must be between 4 to 200 characters")
    private String contentBody;

    @NotEmpty(message = "Publish date is required")
    private String publishDate;

    private UserDto userDto;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentBody() {
        return contentBody;
    }

    public void setContentBody(String contentBody) {
        this.contentBody = contentBody;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
