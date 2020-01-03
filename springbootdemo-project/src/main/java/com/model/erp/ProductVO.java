package com.model.erp;

import lombok.Data;

/**
 * TODO
 *
 * @author hezhensheng3
 * @date 2020-01-03 16:26
 **/
@Data
public class ProductVO {
    private String skuId;
    private String skuName;
    private Double price;
    private Long orgId;
}
