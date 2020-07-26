package com.nubnasir.newsstories.news.service;

import com.nubnasir.newsstories.common.enums.ResponseCodeEnum;
import com.nubnasir.newsstories.common.helper.DateTimeHelper;
import com.nubnasir.newsstories.common.model.OperationResponse;
import com.nubnasir.newsstories.common.service.BaseService;
import com.nubnasir.newsstories.news.converter.NewsStoryModelConverter;
import com.nubnasir.newsstories.news.model.dtos.NewsStoryDto;
import com.nubnasir.newsstories.news.model.dtos.NewsStoryPageData;
import com.nubnasir.newsstories.news.model.entity.NewsStory;
import com.nubnasir.newsstories.news.repository.NewsStoryRepository;
import com.nubnasir.newsstories.user.model.entity.UserEntity;
import com.nubnasir.newsstories.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by root on 9/10/18.
 */
@Transactional
@Service
public class NewStoryService extends BaseService {

    @Autowired
    private NewsStoryRepository newsStoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NewsStoryModelConverter newsStoryModelConverter;

    public NewsStory getEntityById(long id){
        return newsStoryRepository.getById(id);
    }

    public NewsStory getEntityByIdAndUserId(long id, long userId){
        return newsStoryRepository.getByIdAndUserId(id, userId);
    }

    public NewsStoryDto getById(long id){
        return newsStoryModelConverter.convertEntityToDto(newsStoryRepository.getById(id));
    }
    public NewsStoryDto getByIdAndUserId(long id, long userId){
        return newsStoryModelConverter.convertEntityToDto(newsStoryRepository.getByIdAndUserId(id, userId));
    }

    public void createNewsStories(NewsStoryDto newsStoryDto, long userId){
        NewsStory newsStory = newsStoryModelConverter.convertDtoToEntity(newsStoryDto);
        UserEntity userEntity = userRepository.getById(userId);
        newsStory.setUser(userEntity);
        newsStoryRepository.create(newsStory);
    }

    public OperationResponse updateNewsStories(NewsStoryDto newsStoryDto, long userId){
        OperationResponse response = new OperationResponse();
        NewsStory newsStory = newsStoryRepository.getByIdAndUserId(newsStoryDto.getId(), userId);
        if(newsStory != null) {
            newsStory.setTitle(newsStoryDto.getTitle());
            newsStory.setContentBody(newsStoryDto.getContentBody());
            newsStory.setPublishDate(DateTimeHelper.convertStringToDate(newsStoryDto.getPublishDate()));
            newsStoryRepository.update(newsStory);
            response.setResponseCode(ResponseCodeEnum.SUCCESS.getCode());
        } else {
            response.setResponseCode(ResponseCodeEnum.FAILED.getCode());
            response.setMessage("News story not found");
        }
        return response;
    }

    public void deleteNewsStories(NewsStory newsStory){
        newsStory.setUser(null);
        newsStoryRepository.delete(newsStory);
    }

    public List<NewsStoryDto> getAllNewsStories(){
        return newsStoryModelConverter.convertEntitiesToDtos(newsStoryRepository.getAll());
    }

    public List<NewsStoryDto> getNewsStoriesForPage(long fromDate, int fromPage, int maxSize, String searchValue, long userId){
        return newsStoryModelConverter.convertEntitiesToDtos(newsStoryRepository.getNewsStories(fromPage*maxSize, maxSize, fromDate, searchValue, userId));
    }

    public long getMaxPageNumber(long fromDate, int maxSize, String searchValue, long userId){
        long countStories = newsStoryRepository.count(fromDate, searchValue, userId);

        long maxPageNumber = countStories / maxSize;
        if(countStories % maxSize != 0){
            maxPageNumber ++;
        }
        return maxPageNumber;
    }

    public NewsStoryPageData getNewsStoriesPageData(long fromDate, int fromPage, int maxSize, String searchValue, long userId){
        NewsStoryPageData newsStoryPageData = new NewsStoryPageData();
        newsStoryPageData.setNewsStoryDtos(this.getNewsStoriesForPage(fromDate, fromPage, maxSize, searchValue, userId));
        newsStoryPageData.setMaxPageNumber(this.getMaxPageNumber(fromDate, maxSize, searchValue, userId));
        return newsStoryPageData;
    }

}
