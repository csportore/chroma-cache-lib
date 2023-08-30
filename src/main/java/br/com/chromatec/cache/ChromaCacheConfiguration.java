package br.com.chromatec.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ChromaCacheConfiguration {

    // Colocar o properties aqui de alguma maneira

    @Bean
    public ChromaCache createChromaCache(@Value("${chroma.cache.name}") String name) {
        return new ChromaCache(name);
    }
    @Bean
    @ConditionalOnBean(ChromaCache.class)
    public CacheManager createCacheManager(@Autowired ChromaCache cache) {
        return new ChromaCacheManager(cache);
    }

}
