package com.nubnasir.newsstories.user.model.entity;

import com.nubnasir.newsstories.news.model.entity.NewsStory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
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
}
