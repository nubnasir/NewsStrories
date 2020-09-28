package com.nubnasir.newsstories.news.converter;

import com.nubnasir.newsstories.common.converter.ModelConverterInterface;
import com.nubnasir.newsstories.common.helper.DateTimeHelper;
import com.nubnasir.newsstories.news.model.dtos.NewsStoryDto;
import com.nubnasir.newsstories.news.model.entity.NewsStory;
import com.nubnasir.newsstories.news.model.thirdparty.ApiNewsStory;
import com.nubnasir.newsstories.user.converter.UserModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NewsStoryModelConverter implements ModelConverterInterface<NewsStory, NewsStoryDto>{

    @Autowired
    private UserModelConverter userModelConverter;

    @Override
    public NewsStory convertDtoToEntity(NewsStoryDto newsStoryDto){
        NewsStory newsStory = new NewsStory();
        newsStory.setId(newsStoryDto.getId());
        newsStory.setTitle(newsStoryDto.getTitle());
        newsStory.setContentBody(newsStoryDto.getContentBody());
        newsStory.setPublishDate(DateTimeHelper.convertStringToDate(newsStoryDto.getPublishDate()));
        return newsStory;
    }

    @Override
    public NewsStoryDto convertEntityToDto(NewsStory newsStory){
        NewsStoryDto newsStoryDto = new NewsStoryDto();
        newsStoryDto.setId(newsStory.getId());
        newsStoryDto.setTitle(newsStory.getTitle());
        newsStoryDto.setContentBody(newsStory.getContentBody());
        newsStoryDto.setPublishDate(DateTimeHelper.convertDateToString(newsStory.getPublishDate()));

        if(newsStory.getUser() !=null ){
            newsStoryDto.setUserDto(userModelConverter.convertEntityToDto(newsStory.getUser()));
        }

        return newsStoryDto;
    }

    @Override
    public List<NewsStoryDto> convertEntitiesToDtos(List<NewsStory> newsStories){
        List<NewsStoryDto> newsStoryDtos = new ArrayList<>();
        for(NewsStory newsStoryModel : newsStories){
            newsStoryDtos.add(convertEntityToDto(newsStoryModel));
        }
        return newsStoryDtos;
    }

    public ApiNewsStory convertToDtoToApi(NewsStoryDto newsStoryDto){
        ApiNewsStory apiNewsStory = new ApiNewsStory();
        apiNewsStory.setId(newsStoryDto.getId());
        apiNewsStory.setTitle(newsStoryDto.getTitle());
        apiNewsStory.setContentBody(newsStoryDto.getContentBody());
        apiNewsStory.setPublishDate(newsStoryDto.getPublishDate());
        apiNewsStory.setPublisherName(newsStoryDto.getUserDto() !=null? newsStoryDto.getUserDto().getFullName() : "Anonymous" );
        return apiNewsStory;
    }
}
