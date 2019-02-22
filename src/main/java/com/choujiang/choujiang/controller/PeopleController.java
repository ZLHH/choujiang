package com.choujiang.choujiang.controller;


import com.choujiang.choujiang.entity.PeopleEntity;
import com.choujiang.choujiang.service.PeopleService;
import com.choujiang.choujiang.utils.R;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;


/**
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-03-01 11:27:41
 */
@RestController
@RequestMapping("/people")
public class PeopleController {

    private Logger logger = LoggerFactory.getLogger(PeopleController.class);

    @Autowired
    private PeopleService peopleService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list() {
        List<PeopleEntity> peopleEntityList = peopleService.queryList();
        for (PeopleEntity peopleEntity : peopleEntityList) {
            String str = "***";
            if (StringUtils.isNotBlank(peopleEntity.getPhone())) {
                StringBuilder sb = new StringBuilder(peopleEntity.getPhone());
                sb.replace(3, 7, str);
                peopleEntity.setPhone(sb.toString());
            }
        }
        return R.ok().put("peopleEntityList", peopleEntityList);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(HttpServletRequest request, String name, String phone, String major) {
        String ip = "";
        ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip.equals("0:0:0:0:0:0:0:1")) {
            ip = "本地";
        }
        logger.info("ip:{}",ip);
        PeopleEntity peoplea = peopleService.queryPeople(name, phone);
        if (peoplea != null){
            logger.info("peoplea:{}",peoplea.toString());
            return R.error("您已签到，请勿重复签到");
        }
        PeopleEntity peopleb = peopleService.queryPhone(phone);
        if (peopleb != null){
            logger.info("peopleb:{}",peopleb.toString());
            return R.error("该手机号已存在");
        }
        PeopleEntity people = peopleService.queryObject(name, ip, phone);
        if (people != null) {
            logger.info("people:{}",people.toString());
            return R.error("您已签到，请勿重复签到");
        }
        PeopleEntity peopleEntity = new PeopleEntity();
        peopleEntity.setName(name);
        peopleEntity.setPhone(phone);
        peopleEntity.setMajor(major);
        peopleEntity.setStatus(0);
        peopleEntity.setIp(ip);
        peopleEntity.setCreateTime(LocalDateTime.now());
        logger.info("保存:{}",peopleEntity.toString());
        peopleService.save(peopleEntity);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody PeopleEntity peopleEntity) {
        peopleService.update(peopleEntity);

        return R.ok();
    }

}
