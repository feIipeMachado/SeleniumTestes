import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.google.CadastroEmail;
import page.google.CadastroInformacoesBasicas;
import page.google.CadastroNomeSenha;

import java.time.Duration;

public class GoogleTest {

    static WebDriver driver;
    static CadastroNomeSenha cadastroNomeSenha;
    static CadastroInformacoesBasicas cadastroInformacoesBasicas;
    static CadastroEmail cadastroEmail;
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://accounts.google.com/lifecycle/steps/signup/name?continue=https://accounts.google.com/&dsh=S654381455:1700262371170575&flowEntry=SignUp&flowName=GlifWebSignIn&followup=https://accounts.google.com/&ifkv=AVQVeyyJ6Fro0x9IeAb8SjQ8W4YVjfw1uB2SUqStweMIKs0OPzPr__o-NlLGU6mXKc6lSU53oCtc&theme=glif&TL=AIBe4_JSDmFpd-dONc2S0MVU8TSprhcT5Ecpdptkn5shYVFkkoGzqJIIT3vm7JUw");

        cadastroNomeSenha = new CadastroNomeSenha(driver);
        cadastroInformacoesBasicas = new CadastroInformacoesBasicas(driver);
        cadastroEmail = new CadastroEmail(driver);
    }

    @Test
    public void test(){
        cadastroNomeSenha.preencherCampoNome();
        cadastroNomeSenha.preencherCampoSobrenome();
        cadastroNomeSenha.apertarBotaoProxima();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        cadastroInformacoesBasicas.preencherCampoDia();
        cadastroInformacoesBasicas.preencherCampoMes();
        cadastroInformacoesBasicas.preencherCampoAno();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        cadastroInformacoesBasicas.preencherCampoGenero();
        cadastroInformacoesBasicas.apertarBotaoProxima();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        cadastroEmail.preencherCampoEmail();
        cadastroEmail.apertarBotaoProxima();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {

    }

}
