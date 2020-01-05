package com.erp.java8;

import com.alibaba.fastjson.JSON;
import com.model.erp.ProductDTO;
import com.model.erp.ProductVO;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

/**
 * TODO
 *
 * @author hezhensheng3
 * @date 2020-01-03 20:56
 **/
public class Demo {
    public static void main(String[] args) {
        /**
         * 本地ProductVO
         * 远程ProductDTO
         * DTO中skuId相同的赋值给VO
         * 过滤DTO中价格为空的促销活动
         * 按照促销价格倒序输出
         */

        List<ProductDTO> dtoList = FilterAndConvert.getProductDTOListMock();
        List<ProductVO> voList = FilterAndConvert.getProductVOListMock();
        Map<Double, Double> map = dtoList.stream()
                .map(productDTO -> productDTO)
                .filter(productDTO -> productDTO.getPrice() != null)
                .collect(toMap(ProductDTO::getPrice, ProductDTO::getPrice));
        System.out.println(JSON.toJSONString(map));
    }
}
