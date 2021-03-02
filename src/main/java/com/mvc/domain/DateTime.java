package com.mvc.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="com-imooc-domain-DateTime")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DateTime implements Serializable {
    @ApiModelProperty(value="")
    private Integer id;

    /**
    *  YYYY-MM-DD HH:MM:SS 8字节
    */
    @ApiModelProperty(value=" YYYY-MM-DD HH:MM:SS 8字节")
    private LocalDateTime dateTime;

    /**
    *  YYYY-MM-DD HH:MM:SS 4字节
    */
    @ApiModelProperty(value=" YYYY-MM-DD HH:MM:SS 4字节")
    private LocalDateTime tmeStamp;

    /**
    *  YYYY-MM-DD 4字节
    */
    @ApiModelProperty(value=" YYYY-MM-DD 4字节")
    private LocalDate date;

    /**
    *  HH:MM:SS 3字节
    */
    @ApiModelProperty(value=" HH:MM:SS 3字节")
    private LocalTime time;

    /**
    * YYYY 1字节
    */
    @ApiModelProperty(value="YYYY 1字节")
    private Object year;

    private static final long serialVersionUID = 1L;
}
