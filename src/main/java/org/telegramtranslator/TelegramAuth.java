package org.telegramtranslator;

import org.apache.commons.codec.digest.HmacUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TelegramAuth {

    public static boolean isValid(String telegramInitData, String botToken) throws Exception {
        Pair<String, String> result = parseInitData(telegramInitData);
        String hash = result.getFirst();
        String initData = result.getSecond();
        byte[] secretKey = new HmacUtils("HmacSHA256", "WebAppData").hmac(botToken);
        String initDataHash = new HmacUtils("HmacSHA256", secretKey).hmacHex(initData);

        return initDataHash.equals(hash);
    }

    private static Pair<String, String> parseInitData(String telegramInitData) throws UnsupportedEncodingException {
        Map<String, String> initData = parseQueryString(telegramInitData);
        initData = sortMap(initData);
        String hash = initData.remove("hash");

        List<String> separatedData = initData.entrySet().stream()
                .map((v) -> v.getKey() + "=" + v.getValue())
                .collect(Collectors.toList());
        return new Pair<>(hash, String.join("\n", separatedData));
    }

    private static Map<String, String> parseQueryString(String queryString) throws UnsupportedEncodingException {
        Map<String, String> parameters = new TreeMap<>();
        String[] pairs = queryString.split("&");
        for (String pair : pairs) {
            int idx = pair.indexOf("=");
            String key = idx > 0 ? URLDecoder.decode(pair.substring(0, idx), StandardCharsets.UTF_8) : pair;
            String value = idx > 0 && pair.length() > idx + 1 ? URLDecoder.decode(pair.substring(idx + 1), StandardCharsets.UTF_8) : null;
            parameters.put(key, value);
        }
        return parameters;
    }

    private static Map<String, String> sortMap(Map<String, String> map) {
        return new TreeMap<>(map);
    }

    public static class Pair<F, S> {
        private final F first;
        private final S second;

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }

        public F getFirst() {
            return first;
        }

        public S getSecond() {
            return second;
        }

        public static <F, S> Pair<F, S> of(F first, S second) {
            return new Pair<>(first, second);
        }
    }
}
