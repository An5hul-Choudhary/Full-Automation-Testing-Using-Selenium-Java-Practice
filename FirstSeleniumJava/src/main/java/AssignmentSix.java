import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class AssignmentSix {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String checkboxId = "checkBoxOption";
        System.out.println("Enter the check box number you want to select");
        String userInput = in.nextLine();

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // id for checkbox 1 is checkBoxOption1
        // id for checkbox 2 is checkBoxOption2
        // id for checkbox 3 is checkBoxOption3


        if(userInput.equals("1") || userInput.equals("2") || userInput.equals("3")){
            // Making the String of checkbox id using user's input
            checkboxId = checkboxId + userInput;
            WebElement inputElement = driver.findElement(By.xpath("//label/input[@id='" + checkboxId +"']"));
            driver.findElement(By.id(checkboxId)).click();

            WebElement parentLabel = inputElement.findElement(By.xpath("./parent::label"));
            String checkBoxIs = parentLabel.getText();

            WebElement dropdownElement = driver.findElement(By.cssSelector("#dropdown-class-example"));
            dropdownElement.click();
            List<WebElement> total = dropdownElement.findElements(By.tagName("option"));
            for(int i=1;i< total.size();i++){

                if(total.get(i).getText().equals(checkBoxIs)){
                    total.get(i).click();
                }
            }

            driver.findElement(By.cssSelector("#name")).sendKeys(checkBoxIs);
            driver.findElement(By.cssSelector("#alertbtn")).click();

            String alertText = driver.switchTo().alert().getText();
            if(alertText.contains(checkBoxIs)){
                System.out.println(checkBoxIs);
                driver.switchTo().alert().accept();
            }
            else{
                System.out.println("Nothing on alert");
            }

        }
        else{
            System.out.println("Invalid Input");
        }



    }

}


