package br.com.chromatec.cache;

import java.util.HashMap;
import java.util.concurrent.Callable;

import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;

public class ChromaCache implements Cache {
	private HashMap<String, Object> content;
	private String name;
	
	public ChromaCache(String name) {
		this.content = new HashMap<>();
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public Object getNativeCache() {
		return this.content;
	}

	public ValueWrapper get(Object key) {
		Object r = this.content.get(key.toString());
		return  r == null ? null : new SimpleValueWrapper(r);
	}

	public <T> T get(Object key, Class<T> type) {
		throw new UnsupportedOperationException();
	}

	public <T> T get(Object key, Callable<T> valueLoader) {
		throw new UnsupportedOperationException();
	}

	public void put(Object key, Object value) {
		this.content.put(key.toString(), value);
	}

	public void evict(Object key) {
		this.content.remove(key.toString());
		
	}

	public void clear() {
		this.content.clear();
	}

	@Override
	public String toString() {
		return "ChromaCache{" +
				"content=" + content +
				", name='" + name + '\'' +
				'}';
	}
}
