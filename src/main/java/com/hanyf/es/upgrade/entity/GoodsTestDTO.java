package com.hanyf.es.upgrade.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: hanyf
 * @Description:
 * @Date: 2018/6/8 18:13
 */
@Data
public class GoodsTestDTO implements Serializable {
    private static final long serialVersionUID = -5721055675909572577L;

    @Field(type= FieldType.Long, index=false, store=true)
    private Long goodsId;
    @Field(type= FieldType.Long, index=false, store=true)
    private Long brandId;
    @Field(type=FieldType.keyword, analyzer="ik_max_word", searchAnalyzer="ik", store=true)
    private String brandName;
    @Field(type=FieldType.text, analyzer="ik_max_word", searchAnalyzer="ik", store=true)
    private String goodsName;
    @Field(type=FieldType.keyword, analyzer="ik_smart", searchAnalyzer="ik", store=true)
    private String goodsCode;
    @Field(type=FieldType.text, analyzer="ik_smart", searchAnalyzer="ik", store=true)
    private String cargoNo;
    @Field(type=FieldType.keyword, analyzer="ik_max_word", searchAnalyzer="ik", store=true)
    private String specification;
    @Field(type=FieldType.text, analyzer="ik_max_word", searchAnalyzer="ik", store=true)
    private String transform;
    @Field(type= FieldType.Double, index=false, store=true)
    private BigDecimal costPrice;

}
