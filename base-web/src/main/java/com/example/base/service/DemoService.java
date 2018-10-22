package com.example.base.service;

import com.example.base.mapper.DemoMapper;
import com.example.base.model.Demo;
import com.example.base.utils.RedisUtils;
import com.example.base.web.dto.DemoDto;
import org.apache.commons.lang3.SerializationUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author peramdy on 2018/9/14.
 */
@Service
public class DemoService {

    @Autowired
    private DemoMapper demoMapper;

    @Autowired
    private RedisUtils redisUtils;

    public DemoDto getDemoDto(Long id) {
        byte[] key = SerializationUtils.serialize("demo_" + id);
        byte[] value = redisUtils.get(key);
        if (value == null) {
            Demo demo = demoMapper.getDemo(id);
            if (demo != null) {
                DemoDto demoDto = new DemoDto();
                BeanUtils.copyProperties(demo, demoDto);
                byte[] result = SerializationUtils.serialize(demoDto);
                redisUtils.set(key, result);
                return demoDto;
            }
        } else {
            DemoDto demoDto = SerializationUtils.deserialize(value);
            return demoDto;
        }
        return null;
    }
}
