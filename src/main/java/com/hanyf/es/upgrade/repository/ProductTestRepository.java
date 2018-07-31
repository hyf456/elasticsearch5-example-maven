package com.hanyf.es.upgrade.repository;


import com.hanyf.es.upgrade.entity.ProductTestDto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * https://docs.spring.io/spring-data/elasticsearch/docs/current/reference/html/
 * <p>
 * Created by hanyf on 2018/1/15 11:03.
 */
public interface ProductTestRepository extends ElasticsearchRepository<ProductTestDto, String> {


}
