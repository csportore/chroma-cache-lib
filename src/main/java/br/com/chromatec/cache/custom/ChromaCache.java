package br.com.chromatec.cache.custom;

import java.util.concurrent.Callable;

import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.stereotype.Component;

@Component
public class ChromaCache implements Cache {

	public String getName() {
		return "Cache Name";
	}

	public Object getNativeCache() {
		throw new UnsupportedOperationException();
	}

	public ValueWrapper get(Object key) {
		return new SimpleValueWrapper(key.toString());
	}

	public <T> T get(Object key, Class<T> type) {
		throw new UnsupportedOperationException();
	}

	public <T> T get(Object key, Callable<T> valueLoader) {
		throw new UnsupportedOperationException();
	}

	public void put(Object key, Object value) {
		// TODO Auto-generated method stub
		
	}

	public void evict(Object key) {
		// TODO Auto-generated method stub
		
	}

	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
}
