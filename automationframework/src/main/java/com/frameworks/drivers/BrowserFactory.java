package com.frameworks.drivers;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public enum BrowserFactory {

    CHROME {

        @Override
        public WebDriver createDriver() {
            return new ChromeDriver();
        }

        @Override
        public ChromeOptions getOptions() {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-extensions");
            options.addArguments("--headless");
            options.addArguments("--disable-inforbars");
            options.addArguments("--disable-notifications");
            options.addArguments("--remote-allow-origins=*");
            options.setAcceptInsecureCerts(true);
            return options;
        }
    },
    FIREFOX {
        @Override
        public WebDriver createDriver() {
            return new FirefoxDriver();
        }

        @Override
        public FirefoxOptions getOptions() {
            FirefoxOptions options = new FirefoxOptions();
            options.setAcceptInsecureCerts(true);
            return options;
        }
    },
    EDGE {
        @Override
        public WebDriver createDriver() {
            return new EdgeDriver();
        }

        @Override
        public EdgeOptions getOptions() {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-inforbars");
            options.addArguments("--disable-notifications");
            options.addArguments("--remote-allow-origins=*");
            options.setAcceptInsecureCerts(true);
            return options;
        }
    },
    SAFARI {
        @Override
        public WebDriver createDriver() {
            return new SafariDriver();
        }

        @Override
        public SafariOptions getOptions() {
            SafariOptions options = new SafariOptions();
            options.setAutomaticInspection(false);
            return options;
        }
    };

    public abstract WebDriver createDriver();

    public abstract MutableCapabilities getOptions();

}

