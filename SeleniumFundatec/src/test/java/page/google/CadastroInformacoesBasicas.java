package page.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CadastroInformacoesBasicas {

    static WebDriver driver;

    public CadastroInformacoesBasicas(WebDriver driver) {
        this.driver = driver;
    }

    public void preencherCampoDia() {
        WebElement dia = driver.findElement(By.id("day"));
        dia.sendKeys("6");
    }

    public void preencherCampoMes() {
        Select mes = new Select(driver.findElement(By.id("month")));
        mes.selectByValue("5");
    }

    public void preencherCampoAno() {
        WebElement ano = driver.findElement(By.id("year"));
        ano.sendKeys("2000");
    }

    public void preencherCampoGenero() {
        Select genero = new Select(driver.findElement(By.id("gender")));
        genero.selectByValue("1");
    }

    public void apertarBotaoProxima() {
        WebElement botao = driver.findElement(By.xpath("//span[contains(text(), 'Próxima')]"));
        botao.click();
    }

}
