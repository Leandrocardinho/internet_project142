import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginTest {

    WebDriver driver; // declarando variavel driver


//Sera executado antes de cada teste
    @BeforeEach
    public void setUp(){
        
        driver = new ChromeDriver(); //iniciando Chrome"
        
        driver.manage().window().maximize(); // Maximiza a janela da pagina ao abrir 

        driver.get("https://the-internet.herokuapp.com/login"); // Abre a paginá web


    }

// Sera executado apos o teste
    @AfterEach
    public void tearDown(){
        driver.quit(); 
        
    }

    //Teste positivo
    @Test
    public void loginComSucesso() {

        driver.findElement(By.cssSelector("#username"))
            .sendKeys("tomsmith");

        driver.findElement(By.cssSelector("#password"))
            .sendKeys("SuperSecretPassword!");

        //click no botão login
        driver.findElement(By.cssSelector("button[type='submit']"))
            .click();

        WebElement mensagem = driver.findElement(By.cssSelector("#flash"));

        // Validação mensagem 
        Assertions.assertTrue(mensagem.getText()
            .contains("You logged into a secure area!"));
            
    }

    //Teste negativo.
    @Test
    public void loginCorretoSenhaIncorreto(){

        driver.findElement(By.cssSelector("#username"))
            .sendKeys("tomsmith");

        driver.findElement(By.cssSelector("#password"))
            .sendKeys("SenhaInvalida");

        driver.findElement(By.cssSelector("button[type='submit']"))
            .click();

        WebElement mensagem = driver.findElement(By.id("flash"));
        
        Assertions.assertTrue(mensagem.getText()
            .contains("Your password is invalid!"));

        
    }

    @Test
    public void loginIncorretoSenhaCorreta(){
        driver.findElement(By.cssSelector("#username"))
            .sendKeys("invalido");

        driver.findElement(By.cssSelector("#password"))
            .sendKeys("SuperSecretPassword!");

        driver.findElement((By.cssSelector("button[type='submit']")))
            .click();
      
        WebElement mensagem = driver.findElement(By.cssSelector("#flash"));

        Assertions.assertTrue(mensagem.getText()
            .contains("Your username is invalid!"));
    }

    @Test
    public void loginIncorretoSenhaIncorreto(){
        driver.findElement(By.cssSelector("#username"))
            .sendKeys("invalido");

        driver.findElement(By.cssSelector("#password"))
            .sendKeys("invalido");

        driver.findElement((By.cssSelector("button[type='submit']")))
            .click();
        
        WebElement mensagem = driver.findElement(By.cssSelector("#flash"));

        Assertions.assertTrue(mensagem.getText()
           .contains("Your username is invalid!"));
           
        }

        @Test
         public void loginVazioSenhaCorreto(){
        driver.findElement(By.cssSelector("#username"))
            .sendKeys("");
        
        driver.findElement(By.cssSelector("#password"))
            .sendKeys("SuperSecretPassword!");

        driver.findElement(By.cssSelector("button[type='submit']"))
            .click();
        
        WebElement mensagem = driver.findElement(By.cssSelector("#flash"));

        Assertions.assertTrue(mensagem.getText()
            .contains("Your username is invalid!"));
    }

    @Test
       public void loginCorretoSenhaVazio(){
        driver.findElement(By.cssSelector("#username"))
            .sendKeys("tomsmith");
        
        driver.findElement(By.cssSelector("#password"))
            .sendKeys("");

        driver.findElement(By.cssSelector("button[type='submit']"))
            .click();
        
        WebElement mensagem = driver.findElement(By.cssSelector("#flash"));

        Assertions.assertTrue(mensagem.getText()
            .contains("Your password is invalid!"));
    }
@Test
    public void loginVazioSenhaVazio(){
        driver.findElement(By.cssSelector("#username"))
            .sendKeys("");

        driver.findElement(By.cssSelector("#password"))
            .sendKeys("");
        
        driver.findElement(By.cssSelector("button[type='submit']"))
            .click();

        WebElement mensagem = driver.findElement(By.cssSelector("#flash"));

        Assertions.assertTrue(mensagem.getText()
            .contains("Your username is invalid!"));
    }

    @Test
    public void loginVazioSenhaInvalida(){
        driver.findElement(By.cssSelector("#username"))
            .sendKeys("");

        driver.findElement(By.cssSelector("#password"))
            .sendKeys("Super");
        
        driver.findElement(By.cssSelector("button[type='submit']"))
            .click();
        
        WebElement mensagem = driver.findElement(By.cssSelector("#flash"));

        Assertions.assertTrue(mensagem.getText()
        .contains("Your username is invalid!"));
    }

    @Test
    public void loginInvalidoSenhaVazia(){
        driver.findElement(By.cssSelector("#username"))
            .sendKeys("tom");
        
        driver.findElement(By.cssSelector("#password"))
            .sendKeys("");

        driver.findElement(By.cssSelector("button[type='submit']"))
            .click();
        
        WebElement mensagem = driver.findElement(By.cssSelector("#flash"));

        Assertions.assertTrue(mensagem.getText()
            .contains("Your username is invalid!"));
    }


}