package com.mvc.timeCovert;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @program: girl
 * @version:
 * @description: 入参出参中日期格式化
 * @author: ling
 * @create: 2021-05-21 16:19
 **/
@RestController
@RequestMapping("time")
public class TimeFormatController {
    /**
     * 不需要加convert等 此方式可成功
     * @param time
     * @return
     */
    @GetMapping("path/{time}")
    public LocalDateTime testPathVariable(@PathVariable @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime time) {
        return time;
    }
     /**
     *
     * @param time
     * @return
     */
    @GetMapping("path1/{time}")
    public LocalDateTime testPathVariable1(@PathVariable LocalDateTime time) {
        return time;
    }
    /**
     * 不需要加convert等 此方式可成功
     * @param time
     * @return
     */
    @GetMapping("request-param")
    public String testRequestParam(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime time) {
        return time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    /**
     * 不需要加convert等 此方式可成功
     * @param time
     * @return
     */
    @GetMapping("request-param1")
    public LocalDate testRequestParam1(@RequestParam LocalDate time) {
        return time;
    }
    /**
     * 需要增加Converter才可以
     * DateHandlerConfig LocalDateTimeAdvice 都可以
     * @param time
     * @return
     */
    @GetMapping("request-param-pojo")
    public TimeParam testRequestParamPojo(TimeParam time) {
        return time;
    }

    @PostMapping("post/request-body-pojo")
    public TimeParam testPostRequestBody(@RequestBody  TimeParam time) {
        return time;
    }





}
