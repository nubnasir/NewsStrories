package com.nubnasir.newsstories.news.model.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NewsStoryPageData {
    private List<NewsStoryDto> newsStoryDtos;
    private long maxPageNumber;
}
