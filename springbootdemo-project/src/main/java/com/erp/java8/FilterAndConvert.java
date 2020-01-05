package com.erp.java8;

import com.alibaba.fastjson.JSON;
import com.model.erp.ProductDTO;
import com.model.erp.ProductVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * TODO
 * java8的collector讲解
 *  https://www.jianshu.com/p/c0d5c3094324
 *
 * @author hezhensheng3
 * @date 2020-01-03 16:34
 **/
public class FilterAndConvert {
    public static void main(String[] args) {
        List<ProductDTO> productDTOList = getProductDTOListMock();

        // 通过orgId分组，装进orgId，List<ProductDTO>的map中
        Map<Long, List<ProductDTO>> map = productDTOList.stream()
                .collect(Collectors.groupingBy(task -> task.getOrgId()));

//        System.out.println(JSON.toJSONString(map));

        // 抽取ProductDTO中的某些属性装进List
        List<Double> orgIdList = productDTOList.stream()
                .map(ProductDTO::getPrice)
                .distinct()
                .filter(price -> price != null)
                .collect(Collectors.toList());
        System.out.println(JSON.toJSONString(orgIdList));

    }

    /**
     * 获取商品数据DTO mock
     * @return
     */
    public static List<ProductDTO> getProductDTOListMock() {
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setSkuId(i + "");
            productDTO.setOrgId(1L);
            productDTO.setSkuName("sku" + i);
            productDTO.setPrice((i + 1) * 11.0);
            productDTOList.add(productDTO);
        }

        ProductDTO productDTO1 = new ProductDTO();
        productDTO1.setSkuId("4");
        productDTO1.setOrgId(2L);
        productDTO1.setSkuName("sku4");
        productDTO1.setPrice(null);
        productDTOList.add(productDTO1);

        return productDTOList;
    }

    /**
     * 获取商品数据VO mock
     * @return
     */
    public static List<ProductVO> getProductVOListMock() {
        List<ProductVO> productVOList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ProductVO productVO = new ProductVO();
            productVO.setSkuId(i + "");
            productVO.setOrgId(1L);
//            productVO.setSkuName("sku" + i);
//            productVO.setPrice(i * 11.0);
            productVOList.add(productVO);
        }
        return productVOList;
    }

}
