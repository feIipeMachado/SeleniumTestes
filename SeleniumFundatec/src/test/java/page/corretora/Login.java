package page.corretora;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class Login {

    static WebDriver driver;

    public Login(WebDriver driver){ this.driver = driver;}

    public void preencherCampoNome() {
        WebElement nome = driver.findElement(By.id("name"));
        nome.sendKeys("laercio");
    }

    public void campoNomeEmBranco() {
        WebElement nome = driver.findElement(By.id("name"));
        nome.click();
    }

    public void preencherCampoSobrenome() {
        WebElement sobrenome = driver.findElement(By.id("lastname"));
        sobrenome.sendKeys("silva cunha");
    }

    public void preencherCampoDataNascimento(String dataNascimentoPreenchida) {
        WebElement dataNascimento = driver.findElement(By.id("date"));
        dataNascimento.sendKeys(dataNascimentoPreenchida);
    }

    public void preencherCampoCpf(String cpfPreenchido) {
        WebElement cpf = driver.findElement(By.id("document"));
        cpf.sendKeys(cpfPreenchido);
    }

    public void preencherCampoDDI() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement ddi = driver.findElement(By.id("ddi"));
        ddi.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement pesquisar = driver.findElement(By.xpath("//body/div[6]/div[1]/input[1]"));
        pesquisar.sendKeys("brasil");
        WebElement brasil = driver.findElement(By.xpath("//a[contains(text(),'Brasil - +55')]"));
        brasil.click();
    }

    public void preencherCampoDdd() {
        WebElement ddd = driver.findElement(By.id("ddd"));
        ddd.sendKeys("51");
    }

    public void preencherCampoTelefone() {
        WebElement telefone = driver.findElement(By.id("phone"));
        telefone.sendKeys("965433555");
    }

    public void preencherCampoEmail(String emailPreenchido) {
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys(emailPreenchido);
    }

    public void preencherCampoConfirmarEmail(String emailPreenchido) {
        WebElement email = driver.findElement(By.id("confEmail"));
        email.sendKeys(emailPreenchido);
    }

    public boolean acharErroEmail() {
        WebElement erroEmail = driver.findElement(By.xpath("//p[contains(text(),'E-mail informado não confere, por favor verifique ')]"));
        if (erroEmail == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean acharErroCpf() {
        apertarBotaoPF();
        WebElement erroCpf = driver.findElement(By.xpath("//span[contains(text(),'CPF inválido')]"));
        if (erroCpf == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean acharErroCpfCurto() {
        apertarBotaoPF();
        WebElement erroCpf = driver.findElement(By.xpath("//span[contains(text(),'Tamanho inválido.')]"));
        if (erroCpf == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean acharErroDataNascimento() {
        apertarBotaoPF();
        WebElement erroDataNascimento = driver.findElement(By.xpath("//span[contains(text(),'A data não pode ser futura')]"));
        if (erroDataNascimento == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean acharErroNomeEmBranco() {
        apertarBotaoPF();
        WebElement erroNome = driver.findElement(By.xpath("//span[contains(text(),'Obrigatório')]"));
        if (erroNome == null) {
            return false;
        } else {
            return true;
        }
    }
    public void checarCaixaTermos() {
        WebElement caixaTermos = driver.findElement(By.xpath("//body/div[@id='root-app']/div[1]/div[1]/form[1]/div[1]/div[3]/div[12]/div[1]/div[1]/div[1]/label[1]/span[1]"));
    }

    public void apertarBotaoCookies() {
        WebElement botao = driver.findElement(By.id("onetrust-accept-btn-handler"));
        botao.click();
    }

    public void apertarBotaoPF() {
        WebElement botao = driver.findElement(By.id("PfButton"));
        botao.click();
    }
    public void apertarBotaoPJ() {
        WebElement botao = driver.findElement(By.id("PjButton"));
        botao.click();
    }
}
