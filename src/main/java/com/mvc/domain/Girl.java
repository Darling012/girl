package com.mvc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * Created by 廖师兄
 * 2016-11-03 23:07
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Girl {

    @Id
    @GeneratedValue
    private Integer id;

 //   @NotBlank(message = "这个字段必传")
    private String cupSize;

    @Min(value = 18, message = "未成年少女禁止入门")
//    @NotNull
//    @Max()
//    @Length()
    private Integer age;

  //  @NotNull(message = "金额必传")
    private Double money;

}
