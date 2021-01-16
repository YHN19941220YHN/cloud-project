package com.bdqn.cloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 实体
 * @author LiFupeng
 * @version V1.0
 * @Package
 * @Title
 * @date 2020/09/17 13:35
 * @company alibaba
 */

@Data                       // set、get
@AllArgsConstructor         // 全参构造
@NoArgsConstructor          // 无参构造
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
