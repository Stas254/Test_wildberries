package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import wildberries.ServiceBasketPage;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class BasketPageService extends BasicTest {
    private ServiceBasketPage serviceBasketPage = new ServiceBasketPage(DriverSingleton.getInstance());
    private WebDriver driver = DriverSingleton.getInstance();


    /*Метод поиска текста вебэлементов названий товаров корзины и добавления их в строковую коллекцию*/
    public List<String> getNamesProdInBasketList() {
        List<String> namesProdInBasketList = new ArrayList<>();
        for (WebElement listName : serviceBasketPage.getNameProdInBasketList()) {
            String ln = listName.getText().replace(",", "").replace(".", "")
                    .replace(" ", "");
            namesProdInBasketList.add(ln);
        }
        Collections.sort(namesProdInBasketList);
        return namesProdInBasketList;
    }

    /*Метод поиска текста вебэлементов цен товаров корзины и добавления их в целочисленную коллекцию*/
    public List<String> getPricesProdInBasketList() {
        List<String> pricesProdInBasketList = new ArrayList<>();
        for (WebElement listPrice : serviceBasketPage.getPriceProdInBasketList()) {
            String lp = listPrice.getText();
            pricesProdInBasketList.add(lp);
        }
        Collections.sort(pricesProdInBasketList);
        return pricesProdInBasketList;
    }

    /*Метод поиска вебэлементов итоговых цен товаров корзины, перевод их в целые числа и сложение*/
    public Integer getNewPricesProdInBasketList() {
        int sum = 0;
        for (WebElement newListPrice : serviceBasketPage.getNewPriceProdInBasketList()) {
            String nlp = newListPrice.getText().replace("₽", "").replace(" ", "");
            int nlp_ = Integer.parseInt(nlp);
            sum += nlp_;
        }
        return sum;
    }

    /*Метод получения итоговой суммы из корзины и перевод строки в целое число*/
    public Integer getVisibleSumInBasket() {
        String res = serviceBasketPage.getResultSum().getText().replace("₽", "").replace(" ", "");
        int res_ = Integer.parseInt(res);
        return res_;
    }
}

