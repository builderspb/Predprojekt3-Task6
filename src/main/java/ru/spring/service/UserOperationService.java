package ru.spring.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.spring.model.User;

@Service
@RequiredArgsConstructor
public class UserOperationService {
    private static final Logger logger = LoggerFactory.getLogger(UserOperationService.class);
    private final UserService userService;


    /**
     * Выполняет последовательность операций над пользователями:
     * 1. Получает список всех пользователей.
     * 2. Добавляет нового пользователя.
     * 3. Обновляет существующего пользователя.
     * 4. Удаляет пользователя.
     * 5. Конкатенация частей кода.
     * 6. Логирование результата.
     *
     * @return строка, содержащая результаты всех операций.
     */
    public String executeOperations() {

        // 1. Получить список всех пользователей
        userService.getAllUsers();

        // 2. Сохранить пользователя
        User newUser = new User(3L, "James", "Brown", (byte) 25);
        String part1 = userService.addUser(newUser);

        // 3. Изменить пользователя
        User updatedUser = new User(3L, "Thomas", "Shelby", (byte) 25);
        String part2 = userService.updateUser(updatedUser);

        // 4. Удалить пользователя
        String part3 = userService.deleteUser(3L);

        // 5. Конкатенация частей кода
        String result = part1 + part2 + part3;

        // 6. Логирование результата
        logger.info("Результат операции: {}", result);

        return result;
    }
}