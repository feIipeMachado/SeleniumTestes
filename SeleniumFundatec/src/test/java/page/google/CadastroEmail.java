package page.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CadastroEmail {

    static WebDriver driver;

    public CadastroEmail(WebDriver driver) {
        this.driver = driver;
    }

    public void preencherCampoEmail() {
        WebElement email = driver.findElement(By.name("Username"));
        email.sendKeys("contateste35642");
    }

    public void apertarBotaoProxima() {
        WebElement botao = driver.findElement(By.xpath("//span[contains(text(), 'Próxima')]"));
        botao.click();
    }

}
