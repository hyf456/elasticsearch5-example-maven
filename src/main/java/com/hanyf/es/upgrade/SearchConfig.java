package com.hanyf.es.upgrade;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.util.CollectionUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanyf on 2018/1/19 21:00.
 */
@Configuration
@EnableElasticsearchRepositories(basePackages = "com.hanyf.es")
public class SearchConfig {


    private static final Logger logger = LoggerFactory.getLogger(SearchConfig.class);


    @Value("${elasticsearch.port}")
    private int esPort;

    @Value("${elasticsearch.clustername}")
    private String esClusterName;

    @Value("#{'${elasticsearch.hosts:localhost:9300}'.split(',')}")
    private List<String> hosts = new ArrayList<>();


    private Settings settings() {
        Settings settings = Settings.builder()
                .put("cluster.name", esClusterName)
                .put("client.transport.sniff", true).build();
        return settings;
    }

//    @Bean
//    protected Client buildClient() {
//        TransportClient preBuiltTransportClient = new PreBuiltTransportClient(settings());
//
//        if (!CollectionUtils.isEmpty(hosts)) {
//            hosts.stream().forEach(h -> {
//                try {
//                    preBuiltTransportClient.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(h), esPort));
//                } catch (UnknownHostException e) {
//                    logger.error("Error addTransportAddress,with host:{}.", h);
//                }
//            });
//        }
//        return preBuiltTransportClient;
//    }

    @Bean
    protected Client buildClient() {
        TransportClient client = new PreBuiltTransportClient(settings());
        if (!CollectionUtils.isEmpty(hosts)) {
            hosts.stream().forEach(host -> {
                try {
                    final String[] hostAndPort = host.split(":");
                    TransportAddress adress = new InetSocketTransportAddress(InetAddress.getByName(hostAndPort[0]), Integer.valueOf(hostAndPort[1]));
                    client.addTransportAddress(adress);
                } catch (UnknownHostException e) {
                    logger.error("Error addTransportAddress,with host:{}.", host);
                }
            });
        }
        return client;
    }


    @Bean
    public ElasticsearchTemplate elasticsearchTemplate() {
        Client client = buildClient();
        return new ElasticsearchTemplate(client);
    }
}
