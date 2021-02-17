package PruebaSeleniumBasico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.GetProperties;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class prueba_netflix {
    private static String URL = "https://www.netflix.com/";
    WebDriver driver;


    @BeforeMethod
    public void setUp (){
        GetProperties properties = new GetProperties();
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();


    }

    @Test(priority = 4)
    public void validarTituloTest() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String tituloEsperado = "Netflix Chile: Ve series online, ve películas online";
        String tituloActual = driver.getTitle();
        Assert.assertEquals(tituloActual, tituloEsperado);
    }

    @Test(priority = 3)
    public void iniciarSesionPageTest(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Iniciar sesión")).click();
        String tituloEsperado = "Netflix";
        String tituloActual = driver.getTitle();
        Assert.assertEquals(tituloActual, tituloEsperado);

        //Validar que texto Inicia sesión este dentro de los H1
        String textoEsperado = "Inicia sesión";
        String textoActual ="";
        List<WebElement> listaH1 = driver.findElements(By.tagName("h1"));
        System.out.println("*********** Lista de H1");
        for (WebElement elementoH1 : listaH1) {
            System.out.println(elementoH1.getText());
            textoActual = elementoH1.getText();
            if(textoActual.contentEquals(textoEsperado)){
                System.out.println("Texto Inicia sesión se encuentra dentro de los H1: "+ elementoH1.getText());
            }else{
                System.out.println("Texto Inicia sesión No se encuentra dentro de los H1");
            }
        }

        //Validar que se encuentre el texto “Iniciar sesión con Facebook” en el sitio
        String textoFacebookEsperado = "Iniciar sesión con Facebook";
        WebElement textoFacebookActual = driver.findElement(By.xpath("//*[@id=\"appMountPoint\"]/div/div[3]/div/div/div[2]/form/div/div/button/div/span"));
        Assert.assertEquals(textoFacebookActual.getText(), textoFacebookEsperado);
    }

    @Test (priority = 2)
    public void loginToNetflixErrorTest() {
        driver.findElement(By.linkText("Iniciar sesión")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("userLoginId")).sendKeys("jesuscorredor.conde@gmail.com");
        driver.findElement(By.name("password")).sendKeys("holamundo");
        driver.findElement(By.xpath("//*[@id=\"appMountPoint\"]/div/div[3]/div/div/div[1]/form/button")).click();

        String mensajeEsperado = "Contraseña incorrecta.";
        WebElement passErrorMensaje = driver.findElement(By.xpath("//*[contains(text(), 'Contraseña incorrecta')]"));
        Assert.assertEquals(passErrorMensaje.getText(),mensajeEsperado);

        WebElement checkRecuerdame = driver.findElement(By.xpath("//*[@id=\"bxid_rememberMe_true\"]"));
        System.out.println(checkRecuerdame.isSelected());

    }


    @DataProvider(name = "email")
    public Object[][] dataProviderEmailTest(){
        return  new Object[][]{
                {"jeni","jeogv@gmail.com"},
                {"juan","prueba@gmail.com"},
                {"pedro","prueba33@gmail.com"}
        };
    }

    @Test(dataProvider = "email")
    public void emailTest(String nombre, String emails){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("el correo de "+nombre+ " es: "+ emails + " enviado como correo valido para test");
        driver.findElement(By.name("email")).sendKeys(emails);
        driver.findElement(By.xpath("//*[@id=\"appMountPoint\"]/div/div/div/div/div/div[2]/div[1]/div[2]/form/div/div/button/span[1]")).click();

    }

    @Test (priority = 1)
    public void printTagsTest (){
       String  etiqueta = tagName();
        List<WebElement> listaEtiqueta = driver.findElements(By.tagName(etiqueta));
        System.out.println("****Lista de etiquetas" + etiqueta);
        for(WebElement elementoEtiqueta : listaEtiqueta){
            System.out.println(elementoEtiqueta.getText());
        }
    }

    public String tagName(){
       return "h1";
    }

    @AfterMethod
    public void closeDriver(){
        driver.close();
    }
}
