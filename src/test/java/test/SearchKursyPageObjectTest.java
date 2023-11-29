package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import test.pages.SearchKursyPage;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;

@DisplayName("Тесты на проверку поиска курсов по названию")
public class SearchKursyPageObjectTest extends ТestBase {

    SearchKursyPage kursyPage = new SearchKursyPage();
    @BeforeEach
    void setUp() {
        open("https://kursy.ru");
    }

    @ValueSource(strings = {
            "Python",
            "JavaScript"
    })
    @ParameterizedTest(name = "Для поискового запроса {0} должен отдавать не пустой список карточек")
    @Tag("WEB")
    @DisplayName("name")
    void searchCourseByName(String searchQuery) {
        kursyPage.setSearchTextInput(searchQuery)
                 .checkSearchResultMoreZero();
    }

    @CsvSource(value = {
                "Python | Алгоритмы и структуры данных на Python. Базовый курс",
                "JavaScript | Fullstack-разработчик на JavaScript",
            },
            delimiter = '|'
    )
    @ParameterizedTest(name = "Для поискового запроса {0},в ответе должна быть курс под названием: {1}")
    @Tag("WEB")
    @Tag("SMOKE")
    void searchResultsShouldContainExpectedCourseName(String searchQuery, String expectedCourseName) {
        kursyPage.setSearchTextInput(searchQuery)
                 .checkSearchResult(expectedCourseName);
    }

    @CsvFileSource(resources = "/test_data/searchResultsShouldContainExpectedCourseName.csv")
    @ParameterizedTest(name = "Чтение данных для теста из файла. Для поискового запроса {0},в ответе должен быть курс под названием: {1}")
    @Tag("WEB")
    @Tag("SMOKE")
    void readFromFileSearchResultsShouldContainExpectedCourseName(String searchQuery, String expectedCourseName) {
        kursyPage.setSearchTextInput(searchQuery)
                 .checkSearchResult(expectedCourseName);
    }

    static Stream<Arguments> readFromSourceSearchResultsShouldContainExpectedCourseName() {
        return Stream.of(
            Arguments.of("Python", "Алгоритмы и структуры данных на Python. Базовый курс"),
            Arguments.of("JavaScript", "Fullstack-разработчик на JavaScript")
        );
    }
    @MethodSource
    @ParameterizedTest
    @Tag("WEB")
    @Tag("REGRESSION")
    void readFromSourceSearchResultsShouldContainExpectedCourseName(String searchQuery, String expectedCourseName) {
        kursyPage.setSearchTextInput(searchQuery)
                 .checkSearchResult(expectedCourseName);
    }
}
