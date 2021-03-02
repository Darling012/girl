package com.imooc.domain;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Entity
public class boy {
    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank(message = "这个字段必传")
    private String cupSize;

    @Min(value = 18, message = "未成年少女禁止入门")
//    @NotNull
//    @Max()
//    @Length()
    private Integer age;

    // @NotNull(message = "金额必传")
    // private Double money;

    @Digits(integer = 6, fraction = 2)
    private BigDecimal money;


}
