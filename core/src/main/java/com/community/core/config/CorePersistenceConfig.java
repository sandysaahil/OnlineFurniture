package com.community.core.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.broadleafcommerce.common.extensibility.context.merge.Merge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.MapFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;


/**
 * 
 * 
 * @author Phillip Verheyden (phillipuniverse)
 */
@Configuration
public class CorePersistenceConfig {

//    @Autowired
//    @Qualifier("webDS")
//    DataSource webDS;
//
//    @Autowired
//    @Qualifier("webSecureDS")
//    DataSource webSecureDS;
//
//    @Autowired
//    @Qualifier("webStorageDS")
//    DataSource webStorageDS;

    @Bean
    public MapFactoryBean blMergedDataSources() throws Exception {
        MapFactoryBean mapFactoryBean = new MapFactoryBean();
        Map<String, DataSource> sourceMap = new HashMap<>();
        sourceMap.put("jdbc/web", getWebDS());
        sourceMap.put("jdbc/webSecure", getWebSecureDS());
        sourceMap.put("jdbc/cmsStorage", getWebStorageDS());
        mapFactoryBean.setSourceMap(sourceMap);

        return mapFactoryBean;
    }
    
    private DataSource getWebStorageDS() {
    		BasicDataSource webStorageDS = new BasicDataSource();
    		webStorageDS.setDriverClassName("com.mysql.jdbc.Driver");
    		webStorageDS.setUrl("jdbc:mysql://localhost:3306/broadleaf?useUnicode=true&amp;characterEncoding=utf8&amp;autoReconnect=true");
    		webStorageDS.setUsername("root");
    		webStorageDS.setPassword("Tun891mink662!");
		return webStorageDS;
	}

	private DataSource getWebSecureDS() {
		BasicDataSource webSecureDS = new BasicDataSource();
		webSecureDS.setDriverClassName("com.mysql.jdbc.Driver");
		webSecureDS.setUrl("jdbc:mysql://localhost:3306/broadleaf?useUnicode=true&amp;characterEncoding=utf8&amp;autoReconnect=true");
		webSecureDS.setUsername("root");
		webSecureDS.setPassword("Tun891mink662!");
		return webSecureDS;
	}

	private DataSource getWebDS() {
		BasicDataSource webDs = new BasicDataSource();
		webDs.setDriverClassName("com.mysql.jdbc.Driver");
		webDs.setUrl("jdbc:mysql://localhost:3306/broadleaf?useUnicode=true&amp;characterEncoding=utf8&amp;autoReconnect=true");
		webDs.setUsername("root");
		webDs.setPassword("Tun891mink662!");
		return webDs;
	}

	@Merge(targetRef = "blMergedPersistenceXmlLocations", early = true)
    public List<String> corePersistenceXmlLocations() {
        return Arrays.asList("classpath*:/META-INF/persistence-core.xml");
    }
    
    @Merge(targetRef = "blMergedEntityContexts", early = true)
    public List<String> entityConfigurationLocations() {
        return Arrays.asList("classpath:applicationContext-entity.xml");
    }
}
