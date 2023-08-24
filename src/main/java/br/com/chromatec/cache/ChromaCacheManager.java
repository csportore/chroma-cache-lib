package br.com.chromatec.cache;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;


@Component
public class ChromaCacheManager implements CacheManager {
	
	private HashMap<String, ChromaCache> caches;
	
	public ChromaCacheManager() {
		this.caches = new HashMap<String, ChromaCache>();
	}
	
	public Cache getCache(String name) {
		/*
		 * Looks like the putIfAbsent approach is better than the get -> check null -> put
		 * because the putVal will be called anyways:
		 * 		return this.caches.putIfAbsent(name, this.caches.get(name));
		 * ...but it may be worse when most caches are already on memory and only get is needed. Gotta check it out.
		*/
		var c = this.caches.get(name);
		
		if (c == null) {
			c = new ChromaCache(name);
			this.caches.put(name, c);
		}
		
		return c;
	}

	public Collection<String> getCacheNames() {
		throw new UnsupportedOperationException();
	}

}
