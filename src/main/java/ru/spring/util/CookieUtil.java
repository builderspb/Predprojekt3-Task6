package ru.spring.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class CookieUtil {

    // Приватный конструктор, чтобы предотвратить создание экземпляров класса
    private CookieUtil() {
        throw new UnsupportedOperationException("Это служебный класс, и его экземпляр не может быть создан");
    }


    /**
     * Извлекает идентификатор сессии из заголовков ответа.
     *
     * @param response объект ResponseEntity, содержащий заголовки ответа.
     * @return Optional с идентификатором сессии.
     */
    public static Optional<String> extractSessionId(ResponseEntity<String> response) {
        List<String> cookies = response.getHeaders().get(HttpHeaders.SET_COOKIE);
        if (cookies != null && !cookies.isEmpty()) {
            String sessionId = cookies.get(0).split(";")[0];
            return Optional.of(sessionId);
        }
        return Optional.empty();
    }
}