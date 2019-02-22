package com.choujiang.choujiang.service;


import com.choujiang.choujiang.dao.PeopleDao;
import com.choujiang.choujiang.entity.PeopleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-03-01 11:27:41
 */
@Service("adminService")
public class PeopleService {

    @Autowired
    private PeopleDao peopleDao;
	
    public List<PeopleEntity> queryList(){return peopleDao.queryList();}
	
	public  void save(PeopleEntity peopleEntity){peopleDao.save(peopleEntity);}

	public PeopleEntity queryObject(String name,String ip,String phone){
        return peopleDao.queryObject(name,ip,phone);
    }

    public PeopleEntity queryPeople(String name,String phone){
        return peopleDao.queryPeople(name,phone);
    }

    public PeopleEntity queryPhone(String phone){
        return peopleDao.queryPhone(phone);
    }
	
    public 	void update(PeopleEntity peopleEntity){peopleDao.update(peopleEntity);}
}
