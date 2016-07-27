package com.mh.service;

import com.mh.dao.UserDao;
import com.mh.entity.BaseEntity;
import com.mh.entity.UserEntity;
import com.mh.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.Lifecycle;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2016/7/25.
 */
@Service("userService")
public class UserService extends BaseService<UserEntity> implements UserServiceImpl {

    @Autowired
    private UserDao userDao;

    @Override
    protected PagingAndSortingRepository<UserEntity, Long> getDao() {
        return userDao;
    }

    public UserEntity getEntity(Long userId) {
        String sqlStr = "select * from mh_user where id=" + userId;
        BaseEntity user = queryOneSql(sqlStr, UserEntity.class);
        return (UserEntity) user;
    }

    public UserEntity getUserById(Long userId) {
        UserEntity userEntity = findOne(userId);
        return userEntity;
    }
}
