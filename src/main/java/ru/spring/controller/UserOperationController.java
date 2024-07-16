package ru.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.spring.service.UserOperationService;

@RestController
@RequiredArgsConstructor
public class UserOperationController {
    private final UserOperationService userOperationService;


    /**
     * Выполняет последовательность операций над пользователями.
     *
     * @return строка, содержащая результаты всех операций.
     */
    @GetMapping("/execute")
    public String executeOperations() {
        return userOperationService.executeOperations();
    }
}