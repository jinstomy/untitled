package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // WebElements
    @FindBy(id = "user-name")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(css = "[data-test='error']")
    private WebElement errorMessage;
    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement noLoginErrorMessage;

    // Actions
    public void enterUsername(String username) {
        try {
            usernameField.sendKeys(username);
        } catch (Exception e) {
            System.out.println("Failed to enter username: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void enterPassword(String password) {
        try {
            passwordField.sendKeys(password);
        } catch (Exception e) {
            System.out.println("Failed to enter password: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void clickLogin() {
        try {
            loginButton.click();
        } catch (Exception e) {
            System.out.println("Failed to click login button: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void login(String username, String password) {
        try {
            enterUsername(username);
            enterPassword(password);
            clickLogin();
        } catch (Exception e) {
            System.out.println("Login failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public String noLoginErrorMessage() {
        return noLoginErrorMessage.getText();
    }

    public String getErrorMessage() {
        try {
            return errorMessage.getText();
        } catch (Exception e) {
            System.out.println("Failed to get error message: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    }

