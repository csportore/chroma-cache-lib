package br.com.chromatec.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(ChromaCacheProperties.class)
@Configuration
public class ChromaCacheConfiguration {

    @Bean
    public ChromaCache createChromaCache(@Autowired ChromaCacheProperties properties) {
        return new ChromaCache(properties.getName());
    }

    @Bean
    @ConditionalOnBean(ChromaCache.class)
    public CacheManager createCacheManager(@Autowired ChromaCache cache) {
        return new ChromaCacheManager(cache);
    }

}
