package com.nubnasir.newsstories.news.converter;

import com.nubnasir.newsstories.common.converter.ModelConverter;
import com.nubnasir.newsstories.common.helper.DateTimeHelper;
import com.nubnasir.newsstories.news.model.dtos.NewsStoryDto;
import com.nubnasir.newsstories.news.model.entity.NewsStory;
import com.nubnasir.newsstories.user.converter.UserModelConverter;
import com.nubnasir.newsstories.user.model.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NewsStoryModelConverter implements ModelConverter<NewsStory, NewsStoryDto> {

    private ModelConverter modelConverter;

    @Autowired
    public NewsStoryModelConverter(UserModelConverter modelConverter) {
        this.modelConverter = modelConverter;
    }

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
            newsStoryDto.setUserDto((UserDto) modelConverter.convertEntityToDto(newsStory.getUser()));
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
}
