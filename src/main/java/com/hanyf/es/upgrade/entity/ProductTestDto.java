package com.hanyf.es.upgrade.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author: hanyf
 * @Description: 测试对象索引
 * @Date: 2018/7/10 16:36
 */
@Data
@Document(indexName="product_test_index", type="product_test_type")
public class ProductTestDto implements Serializable {

    private static final long serialVersionUID = 2632472274093326495L;

    @Id
    @Field(type= FieldType.Long, index=false, store=true)
    private String productId;

    @Field(type=FieldType.Long, index=false, store=true)
    private Long brandId;

    @Field(type=FieldType.text, analyzer="ik_max_word", searchAnalyzer="ik", store=true)
    private String productName;

    @Field(type=FieldType.text, analyzer="ik_max_word", searchAnalyzer="ik", store=true)
    private String productCode;

    @Field(type=FieldType.text, analyzer="ik_smart", searchAnalyzer="ik", store=true)
    private String productNo;

    @Field(type=FieldType.Integer, index=false, store=true)
    private Integer memberSource;

    @Field(type=FieldType.Integer, index=false, store=true)
    private Integer companyId;

    @Field(type=FieldType.Date, index=false, store=true)
    private Date createTime;

    @Field(type=FieldType.Nested, store=true)
    List<GoodsTestDTO> goodsTestDTOList;
}
