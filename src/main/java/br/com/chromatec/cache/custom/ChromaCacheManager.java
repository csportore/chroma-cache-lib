package br.com.chromatec.cache.custom;

import java.util.Collection;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

public class ChromaCacheManager implements CacheManager {

	public Cache getCache(String name) {
		return new ChromaCache();
	}

	public Collection<String> getCacheNames() {
		throw new UnsupportedOperationException();
	}

}
