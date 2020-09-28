package com.nubnasir.newsstories.user.model.entity;

import com.nubnasir.newsstories.news.model.entity.NewsStory;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "password")
    private String password;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "registration_date")
    private Date registrationDate;

    @Column(name = "last_log_in_date")
    private Date lastLogInDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<NewsStory> newsStories;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getLastLogInDate() {
        return lastLogInDate;
    }

    public void setLastLogInDate(Date lastLogInDate) {
        this.lastLogInDate = lastLogInDate;
    }

    public List<NewsStory> getNewsStories() {
        return newsStories;
    }

    public void setNewsStories(List<NewsStory> newsStories) {
        this.newsStories = newsStories;
    }
}
