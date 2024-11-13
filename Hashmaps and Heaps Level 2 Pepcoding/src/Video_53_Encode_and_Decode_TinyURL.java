import java.util.HashMap;

// https://leetcode.com/problems/encode-and-decode-tinyurl/submissions/
// https://practice.geeksforgeeks.org/problems/design-a-tiny-url-or-url-shortener2031/1
public class Video_53_Encode_and_Decode_TinyURL {
    HashMap<String, String> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        StringBuilder sb = new StringBuilder();
        sb.append((char) (Math.floor(Math.random() * 100)));
        while (map.containsKey(sb.toString()))
            sb.append((char) (Math.floor(Math.random() * 100)));
        map.put(sb.toString(), longUrl);
        return sb.toString();

    }

    //    HashMap<String,String> map= new HashMap<>();
    String idToShortURL(long n) {
        String longUrl = Long.toString(n);
        StringBuilder sb = new StringBuilder();
        sb.append((char) (Math.floor(Math.random() * 100)));
        while (map.containsKey(sb.toString()))
            sb.append((char) (Math.floor(Math.random() * 100)));
        map.put(sb.toString(), longUrl);
        return sb.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}
