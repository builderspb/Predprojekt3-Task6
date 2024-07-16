package ru.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.spring.model.User;
import ru.spring.util.CookieUtil;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private static final String BASE_URL = "http://94.198.50.185:7081/api/users";
    private final RestTemplate restTemplate;
    private final HttpHeaders headers = new HttpHeaders();


    /**
     * Получает всех пользователей.
     *
     * @return ResponseEntity с JSON-строкой, содержащей всех пользователей.
     */
    public ResponseEntity<String> getAllUsers() {
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(BASE_URL, HttpMethod.GET, entity, String.class);
        Optional<String> sessionId = CookieUtil.extractSessionId(response);
        sessionId.ifPresent(id -> headers.add(HttpHeaders.COOKIE, id));
        return response;
    }


    /**
     * Добавляет нового пользователя.
     *
     * @param user объект User, который нужно добавить.
     * @return строка с ответом сервера.
     */
    public String addUser(User user) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> entity = new HttpEntity<>(user, headers);
        ResponseEntity<String> response = restTemplate.exchange(BASE_URL, HttpMethod.POST, entity, String.class);
        return response.getBody();
    }


    /**
     * Обновляет существующего пользователя.
     *
     * @param user объект User с обновленными данными.
     * @return строка с ответом сервера.
     */
    public String updateUser(User user) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> entity = new HttpEntity<>(user, headers);
        ResponseEntity<String> response = restTemplate.exchange(BASE_URL, HttpMethod.PUT, entity, String.class);
        return response.getBody();
    }


    /**
     * Удаляет пользователя по ID.
     *
     * @param id идентификатор пользователя, которого нужно удалить.
     * @return строка с ответом сервера.
     */
    public String deleteUser(Long id) {
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(BASE_URL + "/" + id, HttpMethod.DELETE, entity, String.class);
        return response.getBody();
    }
}