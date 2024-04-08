package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import wildberries.ServiceMainPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.time.Duration;

public class MainPageService extends BasicTest {
    private ServiceMainPage serviceMainPage = new ServiceMainPage(DriverSingleton.getInstance());
    private WebDriver driver = DriverSingleton.getInstance();


    /*Метод принятия cookies*/
    public void cookiesOkClick() {
        if (serviceMainPage.getCookiesOkButton().isDisplayed())
            serviceMainPage.getCookiesOkButton().click();
    }

    /*Метод выбора самого малого размера из появляющегося PopUp*/
    public void visibleSize() {
        if (serviceMainPage.getSizeButton().isDisplayed())
            serviceMainPage.getSizeButton().click();
    }

    /*Метод поиска названий выбранных товаров главной страницы и добавления их в строковую коллекцию для сравнения
    со строковой коллекцией названий корзины*/
    public List<String> getProductsList() {
        String oneProd = serviceMainPage.getNameProdList().get(0).getAttribute("aria-label")
                .replace(",", "").replace(".", "").replace(" ", "");
        String twoProd = serviceMainPage.getNameProdList().get(1).getAttribute("aria-label")
                .replace(",", "").replace(".", "").replace(" ", "");
        String threeProd = serviceMainPage.getNameProdList().get(2).getAttribute("aria-label")
                .replace(",", "").replace(".", "").replace(" ", "");
        List<String> productsList = new ArrayList<>();
        Collections.addAll(productsList, oneProd, twoProd, threeProd);
        Collections.sort(productsList);
        return productsList;
    }

    /*Метод поиска цен выбранных товаров главной страницы и добавления их в целочисленную коллекцию для сравнения
    с полученной целочисленной коллекцией цен корзины*/
    public List<String> getPricesList() {
        String onePrice = serviceMainPage.getPriceProdList().get(0).getText();
        String twoPrice = serviceMainPage.getPriceProdList().get(1).getText();
        String threePrice = serviceMainPage.getPriceProdList().get(2).getText();
        List<String> pricesList = new ArrayList<>();
        Collections.addAll(pricesList, onePrice, twoPrice, threePrice);
        Collections.sort(pricesList);
        return pricesList;
    }

    /*Метод выбора и добавления в корзину товаров главной страницы*/
    public MainPageService addInBasketClick() {
        serviceMainPage.getProdAddInBasketButtonList().get(0).click();
        //visibleSize();   //здесь пока проблема
        serviceMainPage.getProdAddInBasketButtonList().get(1).click();
        //visibleSize();   //здесь пока проблема
        serviceMainPage.getProdAddInBasketButtonList().get(2).click();
        //visibleSize();   //здесь пока проблема
        return this;
    }

    /*Метод перехода из главной страницы в корзину*/
    public MainPageService basketGo() {
        serviceMainPage.getBasket().click();
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@class='list-item__price-new wallet']")));
        /*JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        js.executeScript("return document.readyState;").equals("complete");
        wait.until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState;").equals("complete"));*/
        return this;
    }
}

