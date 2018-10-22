package com.example.base.web.controller;

import com.example.base.service.DemoService;
import com.example.base.web.dto.DemoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author peramdy on 2018/9/14.
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    /**
     * @param id
     * @return
     */
    @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
    public ResponseEntity getDemoDto(@PathVariable("id") Long id) {
        DemoDto demoDto = demoService.getDemoDto(id);
        return new ResponseEntity(demoDto, HttpStatus.OK);
    }

}
