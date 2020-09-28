package com.nubnasir.newsstories.user.repository;

import com.nubnasir.newsstories.common.repository.BaseRepository;
import com.nubnasir.newsstories.user.model.entity.UserEntity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends BaseRepository<UserEntity> {

    public UserEntity getByUserName(String userName){
        Criteria criteria = this.getCriteria();
        criteria.add(Restrictions.eq("userName", userName));
        return (UserEntity) criteria.uniqueResult();
    }
}
