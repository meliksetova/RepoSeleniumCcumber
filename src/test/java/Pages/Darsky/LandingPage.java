package Pages.Darsky;

import Pages.BasePage;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class LandingPage extends BasePage {
    By feelsLikeTempLocator=By.xpath("//span[@class='feels-like-text']");
    By lowTempLocator=By.xpath("//span[@class='low-temp-text']");
    By highTempLocator=By.xpath("//span[@class='high-temp-text']");
    By tempChangeLocator=By.xpath("//div[@id='header']//div[@class='selectric-wrapper selectric-units']");
    By tempCLocator=By.xpath("//div[@id='header']//li[@class='last'][contains(text(),'C, mph')]");
    ArrayList<Integer> temperaturesF=new ArrayList<Integer>();
    ArrayList<Integer> temperaturesC=new ArrayList<Integer>();




    public void changeTempSystemToC(){
        clickThis(tempChangeLocator);
        clickThis(tempCLocator);

    }

    public boolean checkTempDisplay(){
        boolean feelsLikeTempDisplayed=isWebElementDisplayed(feelsLikeTempLocator);
        boolean lowTempDisplayed=isWebElementDisplayed(lowTempLocator);
        boolean highTempDisplayed=isWebElementDisplayed(highTempLocator);
        boolean allDisplayed=feelsLikeTempDisplayed && highTempDisplayed && lowTempDisplayed;
        return allDisplayed;
    }

    public void saveTempF(){
        int feelLikeTemp=convertAnyStringIntoInt(getTextFromElement(feelsLikeTempLocator));
        int highTemp=convertAnyStringIntoInt(getTextFromElement(highTempLocator));
        int lowTemp=convertAnyStringIntoInt(getTextFromElement(lowTempLocator));
        temperaturesF.add(feelLikeTemp);
        temperaturesF.add(highTemp);
        temperaturesF.add(lowTemp);
    }


    public void saveTempC(){
        int feelLikeTempC=convertAnyStringIntoInt(getTextFromElement(feelsLikeTempLocator));
        int highTempC=convertAnyStringIntoInt(getTextFromElement(highTempLocator));
        int lowTempC=convertAnyStringIntoInt(getTextFromElement(lowTempLocator));
        temperaturesC.add(feelLikeTempC);
        temperaturesC.add(highTempC);
        temperaturesC.add(lowTempC);
    }

    public boolean compare(){
        boolean equal=true;
        for (int i=0; i<3; i++ ){
            int temp=Math.round (converttempCtoF(temperaturesC.get(i)));
            if(temperaturesF.get(i)!=temp && temperaturesF.get(i)!=++temp && temperaturesF.get(i)!=--temp ){
                equal=false;

            }

        }
        return equal;
    }






}
