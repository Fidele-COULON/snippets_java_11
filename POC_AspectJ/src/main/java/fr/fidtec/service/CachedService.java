package fr.fidtec.service;

import fr.fidtec.cache.Cached;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CachedService {

	@Cached(cacheName="toto")
	public static String message(String input) {
		 return input.toUpperCase();
	}
	 
}
