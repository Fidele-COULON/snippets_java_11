package fr.fidtec;// JCache is the standard caching API for Java.

import org.junit.jupiter.api.Test;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.spi.CachingProvider;

import static org.junit.jupiter.api.Assertions.assertEquals;

// https://www.baeldung.com/jcache
// You can use the JCache API to develop a complete application, without the need to use any Ehcache API Calls.
class JCacheTest {

    @Test
    void simpleTest() {

       CachingProvider cachingProvider = Caching.getCachingProvider();
       CacheManager cacheManager = cachingProvider.getCacheManager();

       MutableConfiguration<String, String> config = new MutableConfiguration<>();

       Cache<String, String> cache = cacheManager.createCache("simpleCache", config);

       cache.put("key1", "value1");
       cache.put("key2", "value2");

       assertEquals("value1", cache.get("key1"));

       cacheManager.close();
    }
}
