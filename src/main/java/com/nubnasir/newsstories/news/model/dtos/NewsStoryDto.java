package com.nubnasir.newsstories.news.model.dtos;

import com.nubnasir.newsstories.user.model.dto.UserDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

@Getter
@Setter
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
}
