package com.hanyf.es.upgrade.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;


/**
 * 商品Document -example
 * <p>
 * Created by hanyf on 2018/1/18 18:03.
 */
@Data
@Document(indexName = ItemDocument.INDEX, type = ItemDocument.TYPE)
public class ItemDocument implements Serializable {

    public static final String INDEX = "items";
    public static final String TYPE = "item";
    private static final long serialVersionUID = 2384023893881097485L;

    public ItemDocument() {
    }

    public ItemDocument(String id, Integer catId, String name, Long price, String description) {
        this.id = id;
        this.catId = catId;
        this.name = name;
        this.price = price;
        this.description = description;
    }
    /**
     * 商品唯一标识
     */
    @Id
    @Field(type = FieldType.keyword)
    private String id;
    /**
     * 类目id
     */
    @Field(type = FieldType.Integer)
    private Integer catId;
    /**
     * 商品名称
     */
    @Field(type = FieldType.text,index = false)
    private String name;
    /**
     * 商品价格
     */
    @Field(type = FieldType.Long)
    private Long price;
    /**
     * 商品的描述
     */
    @Field(type=FieldType.text, analyzer="ik_max_word", searchAnalyzer="ik", store=true)
    private String description;

}
