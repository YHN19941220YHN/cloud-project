package com.bdqn.cloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 项目为前后端分离,传给前端的错误数据
 * @author LiFupeng
 * @version V1.0
 * @Package
 * @Title
 * @date 2020/09/17 13:38
 * @company alibaba
 */
@Data                       // set、get
@AllArgsConstructor         // 全参构造
@NoArgsConstructor          // 无参构造
public class CommonResult<T> {

    // 404
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
