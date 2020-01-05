package com.model.erp;

import lombok.Builder;
import lombok.Data;

/**
 * ProductDTO
 *
 * @author hezhensheng3
 * @date 2020-01-03 16:24
 **/
@Data
public class ProductDTO {
    private String skuId;
    private String skuName;
    private Double price;
    private Long orgId;
}
