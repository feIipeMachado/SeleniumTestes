package page.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CadastroNomeSenha {

    static WebDriver driver;

    public CadastroNomeSenha(WebDriver driver) {
        this.driver = driver;
    }

    public void preencherCampoNome() {
        WebElement nome = driver.findElement(By.id("firstName"));
        nome.sendKeys("conta");
    }

    public void preencherCampoSobrenome() {
        WebElement sobrenome = driver.findElement(By.id("lastName"));
        sobrenome.sendKeys("teste");
    }

    public void apertarBotaoProxima() {
        WebElement botao = driver.findElement(By.xpath("//span[contains(text(), 'Próxima')]"));
        botao.click();
    }
}
