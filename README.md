# Spring User Service

## Описание
Проект представляет собой сервис для управления пользователями с использованием Spring Framework.
Включает в себя функционал для получения, добавления, обновления и удаления пользователей через REST API.

## Структура проекта
- `src/main/java/ru/spring/model/User.java`: Класс модели пользователя.
- `src/main/java/ru/spring/util/CookieUtil.java`: Утилитный класс для работы с куки.
- `src/main/java/ru/spring/service/UserService.java`: Сервисный класс для взаимодействия с REST API.
- `src/main/java/ru/spring/service/UserOperationService.java`: Сервисный класс для выполнения последовательности операций над пользователями.
- `src/main/java/ru/spring/controller/UserOperationController.java`: Контроллер для обработки HTTP-запросов.

## Классы и методы

### User
Модель пользователя с полями:
- `id` (Long): Идентификатор пользователя.
- `name` (String): Имя пользователя.
- `lastName` (String): Фамилия пользователя.
- `age` (Byte): Возраст пользователя.

### CookieUtil
Утилитный класс для работы с куки.
- `extractSessionId(ResponseEntity<String> response)`: Извлекает идентификатор сессии из заголовков ответа.

### UserService
Сервисный класс для взаимодействия с REST API.
- `getAllUsers()`: Получает всех пользователей.
- `addUser(User user)`: Добавляет нового пользователя.
- `updateUser(User user)`: Обновляет существующего пользователя.
- `deleteUser(Long id)`: Удаляет пользователя по ID.

### UserOperationService
Сервисный класс для выполнения последовательности операций над пользователями.
- `executeOperations()`: Выполняет последовательность операций над пользователями (получение всех пользователей, добавление, обновление и удаление пользователя).

### UserOperationController
Контроллер для обработки HTTP-запросов.
- `getAllUsers()`: Получает список всех пользователей.
- `addUser(User user)`: Добавляет нового пользователя.
- `updateUser(User user)`: Обновляет существующего пользователя.
- `deleteUser(Long id)`: Удаляет пользователя по ID.
- `executeOperations()`: Выполняет последовательность операций над пользователями.

## Запуск проекта
1. Склонируйте репозиторий.
2. Откройте проект в вашей IDE.
3. Убедитесь, что у вас установлен Java 17 и Maven.
4. Запустите проект с помощью команды `mvn spring-boot:run`.

## Требования
- Java 17
- Maven
