package com.zane.vo;

import lombok.Data;
import org.mybatis.spring.annotation.MapperScan;

import java.util.Map;

@Data
public class DataVO {
    private Integer value;
    private Map<String,String> itemStyle;

}
