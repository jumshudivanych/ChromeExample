package com.sandbox50572;

import org.openqa.selenium.WebElement;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ChromeDriver implements Runnable {

    private static org.openqa.selenium.chrome.ChromeDriver driver;
    private static String url;//url загружаемои страницы
    private static String name;
    private String login;
    private String password;

    public ChromeDriver(String name, String url) {
        this.name = name;
        this.url = url;
        this.login = login;
        this.password = password;
    }
    public void run() {

        //цикл открывающий 5 вкладок
        for(int i=0; i<5; i++) {

            //TODO ЗАПУСК Chrome
            System.setProperty("webdriver.chrome.driver","C:/idea/chromedriver.exe");
            driver = new org.openqa.selenium.chrome.ChromeDriver();
            driver.manage().window().maximize();
            //неявное ожидание действует всякий раз при поиске элемента
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            //Заходим на страницу google
            driver.get(url);

            //TODO Автооризация в аккаунте google
            //находим элемент воити
            WebElement autorization = driver.findElementById("gb_70");
            //жмем на кнопку
            autorization.click();
            //находим поле login
            WebElement loginField = driver.findElementById("identifierId");
            //вводим E-mail
            loginField.sendKeys("jumshudivanych@gmail.com");
            //жмем кнопку Далее
            WebElement cont = driver.findElementByClassName("CwaK9");
            cont.click();
            //находим поле пароль
            WebElement passField = driver.findElementByName("password");
            //вводим пароль
            passField.sendKeys("1234cani");
            //находим и жмем кнопку
            WebElement cont2 = driver.findElementByClassName("CwaK9");
            cont2.click();

        //переход на саит
        driver.get("https://www.socpublic.com");
        //находим элемент ВОЙТИ

        WebElement input = driver.findElementByClassName("menu-login");
        input.click();
        //находим элемент login
        WebElement loginSocpublic = driver.findElementByName("name");
        //вводим login
        loginSocpublic.sendKeys("jumshudivanych");
        //вводим пароль
        WebElement passwordSocpublic = driver.findElementByName("password");
        passwordSocpublic.sendKeys("1234cani");
        //TODO время на ручной мбход капчи
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //TODO вариант не годится !!! жмем капчу
        //WebElement captcha = driver.findElementByClassName("recaptcha-checkbox-checkmark");
        //captcha.click();
        //находим кнопку Вход
        //WebElement inputClick = driver.findElementByClassName("btn btn-primary");
        //inputClick.click();

            /*
            //находим элемент поиск google
            WebElement googleSearch = driver.findElementById("lst-ib");
            //вводим поисковыи запрос
            googleSearch.sendKeys("https://www.youtube.com/watch?v=3N-B4wkXxYM");
            //находим и жмем
            WebElement search = driver.findElementByName("btnK");
            search.click();
            //находим элемент в поисковой выдаче
            WebElement ritaYouTube = driver.findElementByLinkText("Цветок в технике квиллинг - YouTube");                //жмем
            ritaYouTube.click();



            //TODO время задержки
            try {
                Thread.sleep(250000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            driver.quit();//завершение работы браузера

            */
            //инициализация генератора случаиных чисел
            //Random random = new Random();
            //получение случайного числа
            // a = random.nextInt(6);
            //перевод в минуты
            //a = a * 60000;

            //вывод количества проиденных циклов
           // System.out.println(i);
            //System.out.println("Задержка равна " + a / 60000);

            //задержка
           // try {
            //    Thread.sleep(a);
            //} catch (InterruptedException e) {
            //    e.printStackTrace();
            //}
        }
        //закрытие 4 вкладок
        for(int i=0; i<4; i++) {
            driver.quit();
            //TODO при закрытии автоматически не возвращает управление в оставшиеся открытыми
            driver.switchTo();//TODO ???
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
