package wildberries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ServiceBasketPage {
    private final WebDriver driver;

    public ServiceBasketPage(WebDriver driver) {
        this.driver = driver;
    }

    /*Описание каждого продукта на странице корзины*/
    By nameProdInBasket = By.xpath("//a[@class='good-info__title j-product-popup']");

    /*Цена каждого товара в корзине, которую сравним с ценой этого товара на главной странице*/
    By priceProdInBasket = By.xpath("//div[@class='list-item__price-wallet']");

    /*Цена каждого товара в корзине, которую сравним с результатом общей суммы*/
    By newPriceProdInBasket = By.xpath("//div[@class='list-item__price-new wallet']");

    /*Итоговая сумма всех товаров в корзине*/
    By resultSum = By.xpath("//p[@class='b-top__total line']//span//span");


    /*Метод получения коллекции вебэлементов названий товаров корзины*/
    public List<WebElement> getNameProdInBasketList() {
        List<WebElement> nameProdInBasketList = driver.findElements(nameProdInBasket);
        return nameProdInBasketList;
    }

    /*Метод получения коллекции вебэлементов цен товаров корзины, которую сравним с коллекцией цен главной страницы*/
    public List<WebElement> getPriceProdInBasketList() {
        List<WebElement> priceProdInBasketList = driver.findElements(priceProdInBasket);
        return priceProdInBasketList;
    }

    /*Метод получения коллекции вебэлементов итоговых цен товаров корзины, которую сравним с итоговой общей суммой*/
    public List<WebElement> getNewPriceProdInBasketList() {
        List<WebElement> newPriceProdInBasketList = driver.findElements(newPriceProdInBasket);
        return newPriceProdInBasketList;
    }

    /*Метод получения итоговой общей суммы покупки корзины*/
    public WebElement getResultSum() {
        return driver.findElement(resultSum);
    }

}