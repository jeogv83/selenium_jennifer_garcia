package Practico10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.GetProperties;

import java.util.List;

public class practico10 {

    @Test
    public WebDriver getDriver (String URL){ //ejercicio9
        GetProperties properties = new GetProperties(); // Nos permite setear el chromeDriver
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);
        WebDriver driver = new ChromeDriver();
        // String baseURL = "https://www.google.com/";
        String baseURL = URL;
        driver.get(baseURL);

        return driver; //retornar un objeto de tipo Webdriver recibe por parametro URL

    }

    @Test
    public void forgotAccount () throws InterruptedException { // Ejercicio 1

        WebDriver driver = getDriver("https://www.facebook.com/");

        Thread.sleep(2000);
        driver.findElement(By.linkText("¿Has olvidado los datos de la cuenta?")).click();

        driver.quit();
    }

    @Test
    public void forgotAccountPartialLink () throws InterruptedException { // Ejercicio 2
        WebDriver driver = getDriver("https://www.facebook.com/");

        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("¿Has olvidado")).click();

        driver.quit();
    }

    @Test
    public void customSalesforceLink () { // Ejercicio 3
        WebDriver driver = getDriver("https://login.salesforce.com/");

        driver.findElement(By.linkText("Utilizar dominio personalizado")).click();
        driver.findElement(By.id("mydomain")).sendKeys("as");
        driver.findElement(By.id("mydomainContinue")).click();

        driver.navigate().back();

        driver.quit();
    }

    @Test
    public void checkBoxAndComboboxTest () throws InterruptedException { // Ejercicio 4
        WebDriver driver = getDriver("https://www.facebook.com/");

        driver.findElement(By.xpath("//a[@id='u_0_2']")).click();

        Thread.sleep(3000);
        WebElement sexo = driver.findElement(By.name("sex"));
        Thread.sleep(3000);
        WebElement sexoF = driver.findElement(By.xpath("//input[@id='u_1_2']"));
        sexoF.click();

        WebElement meses = driver.findElement(By.name("birthday_month"));
        Select combo = new Select(meses);
        List<WebElement> opcionMes = combo.getOptions();
        for (WebElement opc : opcionMes){
            System.out.println(opc.getText());
        }
        combo.selectByValue("3");

        WebElement nombre = driver.findElement(By.name("firstname"));
        nombre.sendKeys("The");

        driver.quit();

    }

    @Test
    public void checkBoxTest() throws InterruptedException { //Ejercicio 5
        WebDriver driver = getDriver("https://www.facebook.com/");

        driver.findElement(By.xpath("//a[@id='u_0_2']")).click();

        Thread.sleep(3000);
        WebElement sexo= driver.findElement(By.name("sex"));
        System.out.println("Sexo fue seleccionado? " +sexo.isSelected());
        Assert.assertTrue(!sexo.isSelected());

        Thread.sleep(2000);
        WebElement masculino = driver.findElement(By.cssSelector("[name='sex'][value='2']"));
        masculino.click();

        System.out.println("Fue seleccionado sexo masculino: " + masculino.isSelected());
        Assert.assertTrue(masculino.isSelected());


        driver.quit();

    }

    @Test
    public void birthdateTest () throws InterruptedException { //Ejercicio 6

        WebDriver driver = getDriver("https://www.facebook.com/");

        driver.findElement(By.xpath("//a[@id='u_0_2']")).click();

        Thread.sleep(2000);
        WebElement dia = driver.findElement(By.name("birthday_day"));
        Select comboDia = new Select(dia);
        comboDia.selectByVisibleText("20");

        WebElement mes = driver.findElement(By.name("birthday_month"));
        Select comboMes = new Select(mes);
        comboMes.selectByVisibleText("dic");

        WebElement anio = driver.findElement(By.name("birthday_year"));
        Select comboAnio = new Select(anio);
        comboAnio.selectByVisibleText("1990");

        driver.quit();

    }

    @Test
    public void comboboxTest () throws InterruptedException { //ejercicio 7
        WebDriver driver = getDriver("https://www.facebook.com/");
        driver.findElement(By.xpath("//a[@id='u_0_2']")).click();

        Thread.sleep(2000);
        WebElement mes = driver.findElement(By.name("birthday_month"));
        Select comboMes = new Select(mes);

        List<WebElement> opciones = comboMes.getOptions();
        Assert.assertNotEquals(0, opciones.size());

        boolean encontroMes = false;

        for (WebElement opcionMes : opciones){

            System.out.println(opcionMes.getText());
            if(opcionMes.getText().contentEquals("mar")){
                encontroMes = true;
            }

        }


        Assert.assertTrue(encontroMes);

        driver.quit();

    }

    @Test
    public void completeRegistration() throws InterruptedException { //ejercicio 9 y 8
        WebDriver driver = getDriver("https://www.facebook.com/");
        driver.findElement(By.xpath("//a[@id='u_0_2']")).click();

        Thread.sleep(2000);
        WebElement nombre = driver.findElement(By.name("firstname"));
        nombre.sendKeys("John");

        WebElement apellido = driver.findElement(By.name("lastname"));
        apellido.sendKeys("Smith");

        WebElement telefono = driver.findElement(By.name("reg_email__"));
        telefono.sendKeys("5555555");

        WebElement contraseña = driver.findElement(By.id("password_step_input"));
        contraseña.sendKeys("123456789");

        WebElement sexo = driver.findElement(By.name("sex"));
        WebElement femenino = driver.findElement(By.cssSelector("[name='sex'][value='1']"));

        setBirthdate(driver, "26", "jun", "1980");

    }
    private void setBirthdate(WebDriver driver, String day, String month, String year){ //ejercicio 8


        WebElement dia = driver.findElement(By.name("birthday_day"));
        Select comboDia = new Select(dia);
        comboDia.selectByVisibleText(day);

        WebElement mes = driver.findElement(By.name("birthday_month"));
        Select comboMes = new Select(mes);
        comboMes.selectByVisibleText(month);

        WebElement anio = driver.findElement(By.name("birthday_year"));
        Select comboAnio = new Select(anio);
        comboAnio.selectByVisibleText(year);
    }
    
}
