package com.choujiang.choujiang.dao;


import com.choujiang.choujiang.entity.PeopleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-03-01 11:27:41
 */
@Mapper
public interface PeopleDao {

    List<PeopleEntity> queryList();

    PeopleEntity queryObject(@Param("name") String name, @Param("ip") String ip, @Param("phone") String phone);

    PeopleEntity queryPeople(@Param("name") String name, @Param("phone") String phone);

    PeopleEntity queryPhone(String phone);

    void save(PeopleEntity peopleEntity);

    void update(PeopleEntity peopleEntity);
}
