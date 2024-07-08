# Diplom_1
Покрытие юнит-тестами кода разработчика.

## Содержание
- [Технологии](#технологии)
- [Как запускать](#как_запускать)
- [Отчет jacoco](#отчет_jacoco)

## Технологии
- [Java 11](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/what-is-corretto-11.html)
- [JUnit 4.13.2](https://mvnrepository.com/artifact/junit/junit/4.13.2)
- [Maven 3.9.0](https://maven.apache.org/docs/3.9.0/release-notes.html)
- [Mockito 3.12.4](https://mvnrepository.com/artifact/org.mockito/mockito-core/3.12.4)
- [Jacoco 0.8.7](https://mvnrepository.com/artifact/org.jacoco/jacoco-maven-plugin/0.8.7)

## Как_запускать
```
mvn clean test
```

## Отчет_jacoco
Чтобы посмотреть отчёт выполни команду:
```
mvn verify
```
Второй способ запуска:
Для этого в IDEA нажми Ctrl дважды. Откроется окно: напиши в нём эту команду.
Найди в папке target/site/jacoco/ файл index.html, нажми на него правой кнопкой мыши и выбери Open In — Browser — твой браузер.

В отчёте отображается процент покрытых строк кода — столбец Missed Instructions. Процент покрытых ветвей — столбец Missed Branches.


