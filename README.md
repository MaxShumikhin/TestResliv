Используемые технологии: Spring MVC;
orm - Hibernate;
конейнер сервлетов - Tomcat(8.5.47);
JSP;
DB - mySQL;
cборка проекта - Maven;
среда разработки - Intellij idea.

Для запуска проекта необходимо: 
1) Прописать настройки подключения к DB (src/main/resources/database.properties), где необходимо указать логин/пароль, а также название db (у меня "turfirma").
- для создания (и возможно наполнения стандартными данными) можно воспользоваться файлом database.txt , где находится скрипт.
- также можно создать только db таблицу в ней автоматически создаст проект при запуске.


2)Настроить контейнер сервлетов Tomcat.

3) Запустить приложение, вместе с запуском web состовляющей приложения также запускается Телеграм-бот (src/main/java/test/bot). Токен и имя бота находится в файле bot.txt

4) Протестировать основные функции: добавление новой информации/ редактирвоание / удаление / выведение.