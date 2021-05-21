import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

// jsoup info - https://betacode.net/10399/jsoup-java-html-parser

public class Jsoup_parser {
    Jsoup_parser() { }

    public void parse_city(String city) {
        Document doc = null;
        Elements body_news = null;
        Elements time_news = null;

        try {
            doc = Jsoup.connect("https://" + city + ".mk.ru/news/")
                    .userAgent("Chrome/4.0.249.0 Safari/532.5")
                    .referrer("http://www.google.com")
                    .get();
        } catch (IOException e) {
            System.out.println("Некорректный запрос");
            return;
        } catch (IllegalArgumentException e) {
            System.out.println("Некорректный запрос");
            return;
        }
        System.out.println("Последние 10 новостей за сегодня:");
        if(doc != null) {
            for(Integer i = 1; i != 11; i++)
            {
                body_news = doc.select("body > div.wraper > div.wraper__content > div > div.article-grid__content.news-listing > section:nth-child(4) > ul > li:nth-child(" + i.toString() + ") > a > h3");
                time_news = doc.select("body > div.wraper > div.wraper__content > div > div.article-grid__content.news-listing > section:nth-child(4) > ul > li:nth-child(" + i.toString() + ") > a > span");
                System.out.println(i + ") " + time_news.text() + " " + body_news.text());
            }
        }
    }

    public void print_city() {
        System.out.println("Теги поддерживаемых городов:");
        System.out.println("1) Kazan (Казань)\n2) Ufa (Уфа)\n3) Spb (Санкт-Петербург)\n4) Ast (Астрахань)\n5) Vlad (Владивосток)");
        System.out.println("6) Eburg (Екатеринбург)\n7) Izhevsk (Ижевск)\n8) Kuban (Кубань)\n9) Mkala (Махачкала)\n10) Tumen (Тюмень)\n");
    }
}
