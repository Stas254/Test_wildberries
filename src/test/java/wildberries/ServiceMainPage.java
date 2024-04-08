package wildberries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ServiceMainPage {

    private final WebDriver driver;

    /*Кнопка принятия cookies*/
    By cookiesOkButton = By.xpath("//button[@class='cookies__btn btn-minor-md']");

    /*Кнопка выбора самого малого размера в появляющемся PopUp (пробный)*/
    By sizeButton = By.xpath("//div[@class='popup__content']/descendant::li[@class='sizes-list__item']");

    /*Переход в корзину*/
    By basket = By.xpath("//div[@class='navbar-pc__item j-item-basket']");

    /*Описание каждого продукта на главной странице*/
    By nameProd = By.xpath("//div[@class='product-card__wrapper']/descendant::a[@class='product-card__link j-card-link j-open-full-product-card']");

    /*Кнопка добавления в корзину каждого товара главной страницы*/
    By prodAddInBasketButton = By.xpath("//a[@class='product-card__add-basket j-add-to-basket btn-main']");

    /*Цена каждого продукта на главной странице*/
    By priceProd = By.xpath("//div[@class='product-card__wrapper']//ins[@class='price__lower-price wallet-price']");

    public ServiceMainPage(WebDriver driver) {
        this.driver = driver;
    }

    /*Метод поиска и возврата кнопки принятия cookies OK*/
    public WebElement getCookiesOkButton() {
        return driver.findElement(cookiesOkButton);
    }

    /*Метод поиска и возврата кнопки выбора самого маленького размера (пробный, пока не удалось осуществить)*/
    public WebElement getSizeButton() {
        return driver.findElement(sizeButton);
    }

    /*Метод получения коллекции вебэлементов кнопок добавления в корзину товаров главной страницы*/
    public List<WebElement> getProdAddInBasketButtonList() {
        List<WebElement> prodAddInBasketButtonList = driver.findElements(prodAddInBasketButton);
        return prodAddInBasketButtonList;
    }

    /*Метод получения коллекции вебэлементов названий товаров главной страницы*/
    public List<WebElement> getNameProdList() {
        List<WebElement> nameProdList = driver.findElements(nameProd);
        return nameProdList;
    }

    /*Метод получения коллекции вебэлементов цен товаров главной страницы*/
    public List<WebElement> getPriceProdList() {
        List<WebElement> priceProdList = driver.findElements(priceProd);
        return priceProdList;
    }

    /*Метод поиска и возврата кнопки перехода в корзину главной страницы*/
    public WebElement getBasket() {
        return driver.findElement(basket);
    }

}
