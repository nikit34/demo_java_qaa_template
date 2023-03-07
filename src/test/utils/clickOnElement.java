package test.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class clickOnElement {

    public static void main(String[] args) {
        try {
            AppiumDriver<MobileElement> appiumDriver;

            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_XL_API_29");
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            desiredCapabilities.setCapability("AppPackage", "skyeng.words.prod");
            desiredCapabilities.setCapability("appActivity", "skyeng.words.ui.main.MainActivity");

            URL appiumServer = new URL("http://localhost:4723/wd/hub");

            appiumDriver = new AppiumDriver<>(appiumServer, desiredCapabilities);
            appiumDriver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);

            MobileElement scheduleTabButton = appiumDriver.findElementByAccessibilityId("Расписание");
            scheduleTabButton.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
