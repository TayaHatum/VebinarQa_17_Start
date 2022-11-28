import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Star {
    WebDriver wd;


    @BeforeMethod
    public void precondition(){
        wd=new ChromeDriver();
        wd.get("file:///Users/tayahatum/Downloads/apk/index.html");

    }
    @Test
    public void tableTests(){
        // print amount of table rows


        List<WebElement> rows = wd.findElements(By.cssSelector("tr"));
        System.out.println("Count of Rows -->" +rows.size());
        // print amount of table cols
        List<WebElement> columns = wd.findElements(By.cssSelector("th"));
        System.out.println("Count of Columns -->" +columns.size());
        // print content of row3
        List<WebElement> row3 = wd.findElements(By.cssSelector("tr:nth-child(3) td"));
        for (WebElement el:row3) {
            System.out.println(el.getText());
        }
        System.out.println("**********");
        WebElement r3 = wd.findElement(By.cssSelector("tr:nth-child(3)"));
        r3.findElements(By.cssSelector("td"));
        System.out.println(r3.getText());
        System.out.println("**********");
        System.out.println(wd.findElement(By.cssSelector("table")).getText());
        // print content of last col
        List<WebElement> lastColumns = wd.findElements(By.cssSelector("td:last-child"));
        for (WebElement el:lastColumns) {
            System.out.println(el.getText());
        }
        // Assert with name "Canada"
        WebElement canada = wd.findElement(By.cssSelector("tr:nth-child(3) td:last-child"));
        String text =canada.getText();
        Assert.assertEquals(text,"Canada");

    }

    @Test
    public void tableTestsCsstoxpath(){
        // print amount of table rows

       // List<WebElement> rows = wd.findElements(By.cssSelector("tr"));
        List<WebElement> rows = wd.findElements(By.xpath("//tr"));
        System.out.println("Count of Rows -->" +rows.size());
        // print amount of table cols
        //List<WebElement> columns = wd.findElements(By.cssSelector("th"));
        List<WebElement> columns = wd.findElements(By.xpath("//th"));
        System.out.println("Count of Columns -->" +columns.size());
        // print content of row3
        //List<WebElement> row3 = wd.findElements(By.cssSelector("tr:nth-child(3) td"));
        List<WebElement> row3 = wd.findElements(By.xpath("//tr[3]//td"));
        //List<WebElement> row3 = wd.findElements(By.cssSelector("tr:nth-child(3)>td"));
        List<WebElement> row3_1 = wd.findElements(By.xpath("//tr[3]/td"));
        for (WebElement el:row3) {
            System.out.println(el.getText());
        }
        System.out.println("**********");
        //WebElement r3 = wd.findElement(By.cssSelector("tr:nth-child(3)"));
        WebElement r3 = wd.findElement(By.xpath("//tr[3]"));
        System.out.println(r3.getText());
        System.out.println("**********");
        System.out.println(wd.findElement(By.cssSelector("table")).getText());
        // print content of last col
       // List<WebElement> lastColumns = wd.findElements(By.cssSelector("td:last-child"));
        List<WebElement> lastColumns = wd.findElements(By.xpath("//td[last()]"));
        for (WebElement el:lastColumns) {
            System.out.println(el.getText());
        }
        // Assert with name "Canada"
       // WebElement canada = wd.findElement(By.cssSelector("tr:nth-child(3) td:last-child"));
        WebElement canada = wd.findElement(By.xpath("//tr[3]//td[last()]"));
        String text =canada.getText();
        Assert.assertEquals(text,"Canada");

    }

    @Test
    public void testIndexFile(){
        // items
        // item 1
        WebElement item1 =wd.findElement(By.tagName("li"));
        wd.findElement(By.cssSelector("li"));
        // item2
        List<WebElement> items =  wd.findElements(By.cssSelector("li"));
        WebElement item2 = items.get(1);
        wd.findElement(By.cssSelector("#nav li:nth-child(2)"));
        // item3
       // List<WebElement> items =  wd.findElements(By.cssSelector("li"));
        WebElement item3 = items.get(2);
        wd.findElement(By.cssSelector("#nav li:nth-child(3)"));
        //item 4
        WebElement item4 = items.get(3);
        wd.findElement(By.cssSelector("#nav li:last-child"));

        // form

        // name
        WebElement inputName = wd.findElement(By.tagName("input"));

        wd.findElement(By.name("name"));
        wd.findElement(By.cssSelector("[name='name']"));
        wd.findElement(By.cssSelector("input[name='name']"));
        // surename
        List <WebElement> names = wd.findElements(By.cssSelector("input"));
        WebElement inputSureName = names.get(1);
        wd.findElement(By.cssSelector("input[name='surename']"));

        // button
        WebElement buttonSend = wd.findElement(By.className("btn"));
        buttonSend.click();
        wd.findElement(By.cssSelector(".btn"));


        // table
         // rows
        wd.findElement(By.cssSelector("table#country-table>tbody>tr"));
        wd.findElement(By.cssSelector("#country-table tr:first-child"));
        wd.findElement(By.cssSelector("#country-table tr:nth-child(2)"));
        wd.findElement(By.cssSelector("#country-table tr:nth-child(3)"));
        wd.findElement(By.cssSelector("#country-table tr:last-child"));

        // td Germany
        //String  text = wd.findElement(By.cssSelector("#country-table tr:nth-child(3)>td:first-child")).getText();
        String  text = wd.findElement(By.cssSelector("tr:nth-child(3)>td:first-child")).getText();
        Assert.assertEquals(text,"Germany");

    }
    @Test
    public void isItem2Select(){
        // step 1 find item2 + click
        // Assert  (text from alert , text item2)

        // click by item 2  !=  item 2
       // Assert.assertTrue(text1.contacns(text2));
    }

    @AfterMethod
    public void postCondition(){
        wd.close();
      //  wd.quit();
    }
}
