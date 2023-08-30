package br.com.chromatec.cache;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@ConfigurationProperties("chroma.cache")
public class ChromaCacheProperties {
    private String name;
}
