package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static java.lang.Thread.sleep;


public class MainTest extends BasicTest {

    private MainPageService mainPageService = new MainPageService();
    private BasketPageService basketPageService = new BasketPageService();

    @Test   //будет недостоверным, если есть выбор размера: ПОКА не удалось победить PopUp
    @DisplayName("Сравнение названий товаров, выбранных на главной странице, и товаров корзины")
    public void inBasketClickAndCompareNamesTest() throws InterruptedException {
        mainPageService.cookiesOkClick();
        mainPageService.addInBasketClick();
        mainPageService.basketGo();
        System.out.println(mainPageService.getProductsList());
        System.out.println(basketPageService.getNamesProdInBasketList());

        Assertions.assertEquals(mainPageService.getProductsList(), basketPageService.getNamesProdInBasketList());
    }

    @Test   //будет недостоверным, если есть выбор размера: ПОКА не удалось победить PopUp
    @DisplayName("Сравнение цен товаров, выбранных на главной странице, и цен товаров корзины")
    public void inBasketClickAndComparePricesTest() throws InterruptedException {
        mainPageService.cookiesOkClick();
        mainPageService.addInBasketClick();
        System.out.println(mainPageService.getPricesList());
        mainPageService.basketGo();
        sleep(7000);      //пока никак без этого, другие ожидания не помогли, сумма не успевает прогрузиться
        System.out.println(basketPageService.getPricesProdInBasketList());

        Assertions.assertEquals(mainPageService.getPricesList(), basketPageService.getPricesProdInBasketList());
    }

    @Test
    @DisplayName("Сравнение суммы цен товаров в корзине с итоговой суммой")
    public void inBasketClickAndCompareResPricesTest() throws InterruptedException {
        mainPageService.cookiesOkClick();
        mainPageService.addInBasketClick();
        mainPageService.basketGo();
        sleep(7000);   //пока никак без этого, другие ожидания не помогли, сумма не успевает прогрузиться
        System.out.println(basketPageService.getNewPricesProdInBasketList());
        System.out.println(basketPageService.getVisibleSumInBasket());

        Assertions.assertEquals(basketPageService.getNewPricesProdInBasketList(), basketPageService.getVisibleSumInBasket());
    }
}

