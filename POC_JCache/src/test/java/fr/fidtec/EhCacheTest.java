package fr.fidtec;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EhCacheTest {

    @Test
    void simpleTest() {
        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder().build();
        cacheManager.init();

        CacheConfiguration<String, String> config = CacheConfigurationBuilder
                .newCacheConfigurationBuilder(
                        String.class, String.class,
                        ResourcePoolsBuilder.heap(10)).build();

        Cache<String, String> cache = cacheManager.createCache("simpleCache", config);

        cache.put("key1", "value1");
        cache.put("key2", "value2");

        assertEquals("value1", cache.get("key1"));

        cacheManager.close();
    }
}
