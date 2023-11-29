package test.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchKursyPage {
    public static final SelenideElement searchTextInput = $("#qplSKIW");
    public static final SelenideElement searchResult = $(".kurses_search_sections");

    public static final ElementsCollection searchResultElements = searchResult.$$(".course-element");

    public SearchKursyPage setSearchTextInput(String value) {
        searchTextInput.setValue(value).pressEnter();
        return this;
    }

    public void checkSearchResultMoreZero() {
        searchResultElements.shouldBe(sizeGreaterThan(0));
    }

    public void checkSearchResult(String value) {
        searchResult.shouldHave(text(value));
    }
}
