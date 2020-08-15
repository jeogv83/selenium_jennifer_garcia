package Practico9;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.*;

import java.util.List;

public class testSelenium1 {


   @Test
    public void ejercicio1 (){
        GetProperties properties = new GetProperties(); // Nos permite setear el chromeDriver
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/"); //Ejercicio 1

        System.out.println("El título de la página es: " + driver.getTitle()); //Ejercicio 2

        driver.close();
    }

   @Test
    public void ejercicio3(){
        //Ejercicio 3
        GetProperties properties = new GetProperties(); // Nos permite setear el chromeDriver
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.bbc.com/mundo");


        List<WebElement> listaH1 = driver.findElements(By.tagName("h1"));
        System.out.println("*********** Lista de H1");
        for (WebElement elementoH1 : listaH1) {
            System.out.println(elementoH1.getText());
        }


        System.out.println("*********** Lista de H2");
        List<WebElement> listaH2 = driver.findElements(By.tagName("h2"));

        for (WebElement elementoH2 : listaH2) {
            System.out.println(elementoH2.getText());
        }


        System.out.println("*********** Lista de H3");
        List<WebElement> listaH3 = driver.findElements(By.tagName("h3"));

        for (WebElement elementoH3 : listaH3) {
            System.out.println(elementoH3.getText());
        }

        driver.navigate().refresh();
        driver.close();
    }

   @Test
    public void ejercicio4(){
        GetProperties properties = new GetProperties(); // Nos permite setear el chromeDriver

        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bbc.com/mundo");

        //Mostrar link y su texto
        List<WebElement> listaLink = driver.findElements(By.tagName("a"));
        System.out.println("*********** Lista de Link");
        for (WebElement elementoLink : listaLink){
            System.out.println(elementoLink.getText());
        }

        //Mostrar la cantidad de párrafos del sitio
        List<WebElement> listaParrafos = driver.findElements(By.tagName("p"));
        System.out.println("La cantidad de párrafos es: " + listaParrafos.size());

        driver.navigate().refresh();
        driver.quit();
    }

    @Test
    public void ejercicio5(){
        GetProperties properties = new GetProperties(); // Nos permite setear el chromeDriver

        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bbc.com/mundo");

        //Mostrar todos los elementos li y su texto
        List<WebElement> listaLi = driver.findElements(By.tagName("li"));
        System.out.println("*********** Lista de li");
        for (WebElement elementoLi : listaLi){
            System.out.println(elementoLi.getText());
        }

        driver.manage().window().fullscreen();
        driver.navigate().refresh();
        driver.quit();
    }

   @Test
    public void ejercicio6(){
        GetProperties properties = new GetProperties(); // Nos permite setear el chromeDriver
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);
        WebDriver driver = new ChromeDriver();
        String baseURL = "https://www.google.com/";
        driver.get(baseURL);

        String expectedTitle= "Google";
        String actualTitle ="";

        actualTitle = driver.getTitle();

        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!!");
        }else{
            System.out.println("Test failed, el titulo actual es: " + actualTitle);
        }

        driver.quit();
    }

  @Test
    public void ejercicio7 (){
        GetProperties properties = new GetProperties(); // Nos permite setear el chromeDriver
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);
        WebDriver driver = new ChromeDriver();
        String baseURL = "https://www.google.com/";
        driver.get(baseURL);

        //Obtener y mostrar el ancho y alto de la página
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();

        System.out.println("El alto de la página es: " + height);
        System.out.println("El ancho de la página es: " + width);

        //Obtener las dimensiones y mostrarla en pantalla
        Dimension size = driver.manage().window().getSize();
        int height1 = size.getHeight();
        int width1 = size.getWidth();
        System.out.println("Las dimensiones son: alto " + height1 + "ancho: " + width1);

        //Setear un nuevo tamaño de pantalla 1024x768
        driver.manage().window().setSize(new Dimension(1024,768));

        //Validar que el ancho y el alto sea el esperado
        height = driver.manage().window().getSize().getHeight();
        Assert.assertEquals(height, 768);

        width = driver.manage().window().getSize().getWidth();
        Assert.assertEquals(width, 1024);

        driver.quit();
    }

   @Test
    public WebDriver ejercicio8 (){
        GetProperties properties = new GetProperties(); // Nos permite setear el chromeDriver
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);
        WebDriver driver = new ChromeDriver();
        String baseURL = "https://www.google.com/";

        driver.get(baseURL);

        return driver; //retornar un objeto de tipo Webdriver

    }

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
    public void ejercicio10(){
        //Acceder a google.com
        //Ingresar en el buscador, la palabra “WebElement” y presionar enter
        WebDriver driver = getDriver("https://www.google.com/");

       System.out.println(driver.getCurrentUrl());

       driver.findElement(By.name("q")).sendKeys("WebElement" + Keys.ENTER);

    }

   @Test
    public void ejercicio11(){
        WebDriver driver = getDriver("https://www.google.com/");

        System.out.println(driver.getTitle()); //Imprimir el título del sitio
        driver.findElement(By.name("q")).sendKeys("selenium driver" + Keys.ENTER);

        driver.navigate().back();        //Volver atras
        driver.navigate().refresh();
        driver.navigate().forward();        //Ir hacia adelante

    }

   @Test
    public void ejercicio12(){
        WebDriver driver = getDriver("https://www.facebook.com/");

        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();
        System.out.println("Navegador: Alto: " + height + "Ancho: " + width); //Imprimir el ancho y el alto del navegador

        driver.manage().window().maximize();

        int heightMax = driver.manage().window().getSize().getHeight();
        int widthMax = driver.manage().window().getSize().getWidth();
        System.out.println("Navegador Maximizado: Alto: " + heightMax + "Ancho: " + widthMax);

        driver.quit();
    }

    @Test
    public void ejercicio13(){
        WebDriver driver = getDriver("https://www.facebook.com/");

        //Cantidad de div que tiene el sitio
        List<WebElement> listaDiv = driver.findElements(By.tagName("div"));
        System.out.println("La cantidad de Div es: " + listaDiv.size());

        List<WebElement> listaBotones = driver.findElements(By.tagName("button"));
        System.out.println("****Lista de Texto de los botones de la página");
        for(WebElement elementoTextoBtn : listaBotones){
            System.out.println(elementoTextoBtn.getText());
        }
        System.out.println("La cantidad de botones de la página es: " + listaBotones.size());

        driver.quit();
    }

    @Test
    public void ejercicio14(){
        WebDriver driver = getDriver("https://www.netflix.com/uy/");

        driver.manage().window().maximize();

        //Mostrar los elementos h1, h2 o h3 que se encuentren en mayor cantidad en el sitio.
        List<WebElement> listaH1 = driver.findElements(By.tagName("h1"));
        List<WebElement> listaH2 = driver.findElements(By.tagName("h2"));
        List<WebElement> listaH3 = driver.findElements(By.tagName("h3"));
        int cantidadH1= listaH1.size();
        int cantidadH2= listaH2.size();
        int cantidadH3= listaH3.size();

        if (cantidadH1 > cantidadH2 && cantidadH1 > cantidadH3){
            System.out.println(" H1 es mayor");
        }else if(cantidadH2 > cantidadH1 && cantidadH2 > cantidadH3){
            System.out.println(" H2 es mayor");
        }else if (cantidadH3 > cantidadH1 && cantidadH3 > cantidadH2){
            System.out.println(" H3 es mayor");
        }


        List<WebElement> listaBtn = driver.findElements(By.tagName("button"));
        System.out.println("****Texto de los botones de la página");

        for (WebElement elementoBotones : listaBtn){
            System.out.println(elementoBotones.getText());
        }

        List<WebElement> listDiv = driver.findElements(By.tagName("div"));
        int cantDiv = listDiv.size();
        System.out.println("Cantidad de div que contiene la página: " + cantDiv);

        System.out.println("El titulo de la página es: " + driver.getTitle());

        List<WebElement> listInput = driver.findElements(By.tagName("input"));
        int cantInput = listInput.size();
        System.out.println("Cantidad de input que contiene la página: " + cantInput);

        List<WebElement> listLink = driver.findElements(By.tagName("link"));
        int cantLink = listLink.size();
        System.out.println("Cantidad de links que contiene la página: " + cantLink);


        driver.navigate().refresh();
        driver.quit();
    }

   @Test
    public void ejercicio15(){
        WebDriver driver = getDriver("https://www.netflix.com/uy/");

        driver.findElement(By.linkText("Iniciar sesión")).click();

        List<WebElement> listaH1 = driver.findElements(By.tagName("h1"));
        System.out.println("*********** Lista de H1");
        for (WebElement elementoH1 : listaH1) {
            System.out.println(elementoH1.getText());
        }


        System.out.println("*********** Lista de H2");
        List<WebElement> listaH2 = driver.findElements(By.tagName("h2"));

        for (WebElement elementoH2 : listaH2) {
            System.out.println(elementoH2.getText());
        }

        driver.navigate().back();        //Volver atras
        driver.navigate().refresh();

        System.out.println("*********** Lista de DIV");
        List<WebElement> listaDiv = driver.findElements(By.tagName("div"));

        for (WebElement elementoDiv : listaDiv) {
            System.out.println(elementoDiv.getText());
        }

        System.out.println("El titulo de la página es: " + driver.getTitle());

        List<WebElement> listInput = driver.findElements(By.tagName("input"));
        int cantInput = listInput.size();
        System.out.println("Cantidad de input que contiene la página: " + cantInput);

        List<WebElement> listLink = driver.findElements(By.tagName("link"));
        int cantLink = listLink.size();
        System.out.println("Cantidad de links que contiene la página: " + cantLink);

        driver.quit();
    }

   /* @Test
    public void ejercicio16(){
        WebDriver driver = getDriver("https://www.spotify.com/uy/");

        //Validar el título de la página
        String resultEsperado = "Escuchar es todo - Spotify";
        String resultActual = driver.getTitle();
        Assert.assertEquals(resultActual, resultEsperado);

        List<WebElement> listParrafos = driver.findElements(By.tagName("p"));
        int cantParrafos = listParrafos.size();
        System.out.println("Cantidad de elementos d etipo párrafo que contiene la página: " + cantParrafos);

        List<WebElement> listLinkA = driver.findElements(By.tagName("a"));
        int cantLinkA = listLinkA.size();
        System.out.println("Cantidad de links <a> que contiene la página: " + cantLinkA);

        List<WebElement> listBotones = driver.findElements(By.tagName("button"));
        System.out.println("*********** Lista del texto de los botones del sitio");
        for(WebElement elementoBtn : listBotones){
            System.out.println(elementoBtn.getText());
        }

        driver.findElement(By.linkText("Ayuda")).click();

        String textoPricipal = driver.findElement(By.tagName("h1")).getText();
        System.out.println("Texto sección principal: " + textoPricipal);

        driver.findElement(By.xpath("//input[@placeholder='Buscar']")).sendKeys("Suscripción");

        driver.findElement(By.linkText("Estado de tu suscripción")).click(); //NO LOGRO ACCEDER A ESTE ELEMENTO

        driver.findElement(By.name("j_id0:j_id1:j_id13:j_id14:feedbackYesNoForm:feedbackYesButton")).click();

        List<WebElement> listLi = driver.findElements(By.tagName("li"));
        System.out.println("*********** Lista de todas las opciones del menú izquierdo de la página");
        for(WebElement elementoLi : listLi){
            System.out.println(elementoLi.getText());
        }

        driver.navigate().back();        //Volver atras
        driver.quit();
    }*/

    @Test
    public void ejercicio17(){
        WebDriver driver = getDriver("https://www.facebook.com/");

        driver.findElement(By.name("email")).sendKeys("test@test.com");
        driver.findElement(By.name("pass")).sendKeys("holamundo");
        driver.findElement(By.name("login")).click();

        driver.quit();
    }
}
