package com.github.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 3/21/19 20:56
 * @Description: Note: This is a companion problem to the System Design problem: Design TinyURL.
 * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.
 * <p>
 * Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 */
public class Leetcode535 {

    class Codec {
        Map<String, String> map = new HashMap<>();

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            String shortened = Integer.toHexString(longUrl.hashCode());
            map.put(shortened, longUrl);
            return shortened;

        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            String longUrl = map.get(shortUrl);
            return longUrl;
        }
    }
}
