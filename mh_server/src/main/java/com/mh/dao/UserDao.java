package com.mh.dao;

import com.mh.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lenovo on 2016/7/25.
 */
@Repository("userDao")
public interface UserDao extends PagingAndSortingRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {
}
