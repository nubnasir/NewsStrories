package com.nubnasir.newsstories.news.repository;

import com.nubnasir.newsstories.common.enums.DateFlagEnum;
import com.nubnasir.newsstories.common.enums.UserTypeEnum;
import com.nubnasir.newsstories.common.helper.DateTimeHelper;
import com.nubnasir.newsstories.common.repository.BaseRepository;
import com.nubnasir.newsstories.news.model.entity.NewsStory;
import org.hibernate.Criteria;
import org.hibernate.criterion.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NewsStoryRepository extends BaseRepository<NewsStory> {

    public List<NewsStory> getAll(){
        Criteria criteria = getCriteria();
        return criteria.list();
    }

    public NewsStory getByIdAndUserId(long id, long userId){
        Criteria criteria = getCriteriaFilteringUserAlias(getCriteria(), userId);
        criteria.add(Restrictions.eq("id", id));

        criteria.setMaxResults(1);
        return (NewsStory) criteria.uniqueResult();
    }

    /**
     * Returns {@link NewsStory} for current page.
     *
     * @param  fromRow      page number from pagination
     * @param  maxRow       maximum number of row in a page. {@link com.nubnasir.newsstories.common.enums.PageSizeEnum}
     * @param  fromDate     long value of date. Ignores @param formDate if @value ALL(0). {@link DateFlagEnum}
     * @param  searchValue  the searched value, search all the string separated by space from news_story table (column title)
     * @param  userId       search for user wise news stories. Ignores if @value ANONYMOUS(-1). {@link UserTypeEnum}
     * @return              long
     * @see                 List<NewsStory> in desired page.
     */
    public List<NewsStory> getNewsStories(int fromRow, int maxRow, long fromDate, String searchValue, long userId){
        Criteria criteria = this.getCriteriaFilteringUserAlias(getCriteria(), userId);

        if(fromDate != DateFlagEnum.ALL.getCode()) {
            criteria.add(Restrictions.gt("publishDate", DateTimeHelper.convertLongToDate(fromDate)));
        }

        if(searchValue !=null && searchValue.trim().length() > 0){
            criteria.add(getDisjunctionForSearchValue(searchValue));
        }
        criteria.addOrder(Order.desc("publishDate"));
        criteria.setFirstResult(fromRow);
        criteria.setMaxResults(maxRow);

        return criteria.list();
    }

    /**
     * Returns number of news stories available for the search.
     *
     * @param  fromDate     long value of date. Ignores @param formDate if @value ALL(0). {@link DateFlagEnum}
     * @param  searchValue  the searched value, search all the string separated by space from news_story table (column title)
     * @param  userId       search for user wise news stories. Ignores if @value ANONYMOUS(-1). {@link UserTypeEnum}
     * @return              long
     */
    public long count(long fromDate, String searchValue, long userId){
        Criteria criteria = this.getCriteriaFilteringUserAlias(getCriteria(), userId);

        if(searchValue !=null && searchValue.trim().length() > 0){
            criteria.add(getDisjunctionForSearchValue(searchValue));
        }

        if(fromDate != DateFlagEnum.ALL.getCode()) {
            criteria.add(Restrictions.gt("publishDate", DateTimeHelper.convertLongToDate(fromDate)));
        }
        criteria.setProjection(Projections.rowCount());

        return (long) criteria.uniqueResult();
    }

    private Disjunction getDisjunctionForSearchValue(String searchValue){
        String[] searchPortion = searchValue.trim().split("\\s+");
        Disjunction disjunction = Restrictions.disjunction();
        for(int i=0; i<searchPortion.length; i++){
            Criterion searchCriterion = Restrictions.like("title", searchPortion[i], MatchMode.ANYWHERE).ignoreCase();
            disjunction.add(searchCriterion);
        }
        return disjunction;
    }

    private Criteria getCriteriaFilteringUserAlias(Criteria criteria, long userId){
        if(userId != UserTypeEnum.ANONYMOUS.getCode()){
            criteria.createAlias("user", "user");
            criteria.add(Restrictions.eq("user.id", userId));
        }
        return criteria;
    }
}
