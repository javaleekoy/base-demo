package com.example.base.web.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author peramdy on 2018/9/14.
 */
@Data
public class DemoDto implements Serializable {

    private Long id;

    private String name;

    private String desc;

    private String remark;

}
