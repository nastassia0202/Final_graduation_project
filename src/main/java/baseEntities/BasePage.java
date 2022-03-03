package baseEntities;

import com.codeborne.selenide.Selenide;

import utils.Trim;

import static constant.Urls.BASE_URL;

public abstract class BasePage {

    protected String pageUrl;

    public BasePage(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public void open() {
        String url = Trim.rtrim(BASE_URL, "/") + "/" + Trim.ltrim(pageUrl, "/");
        Selenide.open(url);
    }
}
