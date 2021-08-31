package com.mvc;

import com.mvc.domain.Girl;
import com.mvc.repository.GirlRepository;
import com.mvc.service.GirlService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 廖师兄
 * 2017-02-14 23:20
 */
@ExtendWith(MockitoExtension.class)
public class GirlServiceTestFast {

    private GirlService girlService;


    @Before
    public void initGirlService() {
         GirlRepository girlRepository = Mockito.mock(GirlRepository.class);

        girlService = new GirlService(girlRepository);
    }

    @Test
    public void findOneTest() {
        Girl girl = girlService.findOne(1);
    }
}
