import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.corretora.Login;
import page.google.CadastroEmail;
import page.google.CadastroInformacoesBasicas;
import page.google.CadastroNomeSenha;

import java.time.Duration;

public class CorretoraTest {
    static WebDriver driver;
    static Login login;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://cliente.advancedcorretora.com.br/signup");
        driver.manage().window().maximize();
        login = new Login(driver);
        login.apertarBotaoCookies();
    }

    @Test
    public void testarEmailDeConfirmacaoErrado(){
        login.preencherCampoEmail("teste@gmail.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        login.preencherCampoConfirmarEmail("teste2@gmail.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        login.acharErroEmail();
    }

    @Test
    public void testarCpfInvalido(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        login.preencherCampoCpf("436.434.634-63");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        login.acharErroCpf();
    }

    @Test
    public void testarCpfCurto(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        login.preencherCampoCpf("436.434.634-6");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        login.acharErroCpfCurto();
    }

    @Test
    public void testarDataNascimentoInvalida(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        login.preencherCampoDataNascimento("1202121212");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        login.acharErroDataNascimento();
    }

    @Test
    public void testarNomeEmBranco(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        login.campoNomeEmBranco();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        login.acharErroNomeEmBranco();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {

    }
}
