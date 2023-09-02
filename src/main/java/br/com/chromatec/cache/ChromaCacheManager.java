package br.com.chromatec.cache;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import java.util.Collection;
import java.util.HashMap;


public class ChromaCacheManager implements CacheManager {
	private HashMap<String, ChromaCache> caches;

	public ChromaCacheManager(ChromaCache cache) {
		this.caches = new HashMap<>();
		this.caches.put(cache.getName(), cache);
	}
	
	public Cache getCache(String name) {
		/*
		 * Looks like the putIfAbsent approach is better than the get -> check null -> put
		 * because the putVal will be called anyways:
		 * 		REMOVED LINE: return this.caches.putIfAbsent(name, this.caches.get(name));
		 * ...but it may be worse IF many caches are to be loaded on memory and only get is needed.
		 * Gotta check it out.
		*/
		var c = this.caches.get(name);
		
		if (c == null) {
			c = new ChromaCache(name);
			this.caches.put(name, c);
		}
		
		return c;
	}

	public Collection<String> getCacheNames() {
		return this.caches.keySet();
	}

	@Override
	public String toString() {
		return "ChromaCacheManager{" +
				"caches=" + caches +
				'}';
	}
}
