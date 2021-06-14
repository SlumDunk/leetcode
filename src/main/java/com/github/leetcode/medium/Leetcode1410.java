package com.github.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * HTML entity parser is the parser that takes HTML code as input and replace all the entities of the special characters by the characters itself.
 * <p>
 * The special characters and their entities for HTML are:
 * <p>
 * Quotation Mark: the entity is &quot; and symbol character is ".
 * Single Quote Mark: the entity is &apos; and symbol character is '.
 * Ampersand: the entity is &amp; and symbol character is &.
 * Greater Than Sign: the entity is &gt; and symbol character is >.
 * Less Than Sign: the entity is &lt; and symbol character is <.
 * Slash: the entity is &frasl; and symbol character is /.
 * Given the input text string to the HTML parser, you have to implement the entity parser.
 * <p>
 * Return the text after replacing the entities by the special characters.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: text = "&amp; is an HTML entity but &ambassador; is not."
 * Output: "& is an HTML entity but &ambassador; is not."
 * Explanation: The parser will replace the &amp; entity by &
 * Example 2:
 * <p>
 * Input: text = "and I quote: &quot;...&quot;"
 * Output: "and I quote: \"...\""
 * Example 3:
 * <p>
 * Input: text = "Stay home! Practice on Leetcode :)"
 * Output: "Stay home! Practice on Leetcode :)"
 * Example 4:
 * <p>
 * Input: text = "x &gt; y &amp;&amp; x &lt; y is always false"
 * Output: "x > y && x < y is always false"
 * Example 5:
 * <p>
 * Input: text = "leetcode.com&frasl;problemset&frasl;all"
 * Output: "leetcode.com/problemset/all"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= text.length <= 10^5
 * The string may contain any possible characters out of all the 256 ASCII characters.
 */
public class Leetcode1410 {
    public String entityParser(String text) {
        Map<String, String> map = new HashMap<>();
        map.put("&quot;", "\"");
        map.put("&apos;", "'");
        map.put("&amp;", "&");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");
        StringBuilder buffer = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (c == '&') {
                if (temp.length() != 0) {
                    buffer.append(temp);
                    temp.delete(0, temp.length());
                }
                temp.append(c);
            } else if (c == ';') {
                temp.append(c);
                buffer.append(map.getOrDefault(temp.toString(), temp.toString()));
                temp.delete(0, temp.length());
            } else {
                if (temp.length() > 0) {
                    temp.append(c);
                } else {
                    buffer.append(c);
                }
            }
        }
        if (temp.length() > 0) {
            buffer.append(temp);
        }
        return buffer.toString();

    }
}
