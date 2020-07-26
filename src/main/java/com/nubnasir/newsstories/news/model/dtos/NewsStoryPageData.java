package com.nubnasir.newsstories.news.model.dtos;

import java.util.List;

/**
 * Created by root on 9/10/18.
 */
public class NewsStoryPageData {

    private List<NewsStoryDto> newsStoryDtos;
    private long maxPageNumber;

    public List<NewsStoryDto> getNewsStoryDtos() {
        return newsStoryDtos;
    }

    public void setNewsStoryDtos(List<NewsStoryDto> newsStoryDtos) {
        this.newsStoryDtos = newsStoryDtos;
    }

    public long getMaxPageNumber() {
        return maxPageNumber;
    }

    public void setMaxPageNumber(long maxPageNumber) {
        this.maxPageNumber = maxPageNumber;
    }
}
