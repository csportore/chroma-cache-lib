package br.com.chromatec.cache.custom;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

@Component
public class ChromaCacheManager implements CacheManager {
	
	private HashMap<String, ChromaCache> caches;

	public Cache getCache(String name) {
		return this.caches.get(name);
	}

	public Collection<String> getCacheNames() {
		throw new UnsupportedOperationException();
	}

}
