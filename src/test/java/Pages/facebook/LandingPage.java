package Pages.facebook;


import Pages.BasePage;
import org.openqa.selenium.By;

public class LandingPage extends BasePage{

        // locators for web-element on Landing Page
        By loginEmailLocator = By.id("email");
        By loginPasswordLocator = By.id("pass");
        By loginButtonLocator = By.id("loginbutton");
        By fNameLocator=By.name("firstname");
        By lNameLocator=By.name("lastname");
        By mobileLocator=By.name("reg_email_");



        public void enterLoginEmail(String userEmail) {
            type(loginEmailLocator, userEmail);
        }

        public void enterLoginPassword(String userPassword) {
            type(loginPasswordLocator, userPassword);
        }

        public void clickLoginButton() {
            clickThis(loginButtonLocator);
        }


    }



