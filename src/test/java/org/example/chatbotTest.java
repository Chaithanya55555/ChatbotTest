package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
public class chatbotTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver obj = new ChromeDriver();
        obj.get("https://qachatbot.ccbp.tech/");
        WebElement input = obj.findElement(By.xpath("//input[@id = 'userInput']"));
        input.sendKeys("Hi");
        WebElement button = obj.findElement(By.xpath("//button[starts-with(@id,'sendMsg')]"));
        button.click();
        input.sendKeys("Good Morning");
        button.click();
        input.sendKeys("Help!!");
        button.click();
        List<WebElement> allMsg = obj.findElements(By.xpath("//div[@id = 'chatContainer']/descendant::span"));
        for (int i = 0; i <allMsg.size() ; i++) {
            System.out.println(allMsg.get(i).getText());
        }
        obj.quit();
    }
}
