package com.mvc.service;

import com.mvc.domain.Girl;
import com.mvc.enums.ResultEnum;
import com.mvc.exception.GirlException;
import com.mvc.repository.GirlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by 廖师兄
 * 2016-11-04 00:08
 */
@Service
@RequiredArgsConstructor
public class GirlService {

    // @Autowired
    private final GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRepository.save(girlA);


        Girl girlB = new Girl();
        girlB.setCupSize("BBBB");
        girlB.setAge(19);
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception {
        Optional<Girl> optionalGirl = girlRepository.findById(id);
        Girl girl = optionalGirl.get();
        Integer age = girl.getAge();
        if (age < 10) {
            //返回"你还在上小学吧" code=100
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age > 10 && age < 16) {
            //返回"你可能在上初中" code=101
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }

        //如果>16岁,加钱
        //...
    }

    /**
     * 通过Id查询一个女生的信息
     *
     * @param id
     * @return
     */
    public Girl findOne(Integer id) {
        Optional<Girl> optionalGirl = girlRepository.findById(id);
        Girl girl = optionalGirl.get();
        return girl;
    }
}
