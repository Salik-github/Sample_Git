package com.frameworks.enums;

import org.openqa.selenium.WebDriver;

public enum browserType {
    
    CHROME,
    FIREFOX,
    EDGE,
    SAFARI;

    Object toUpperCase() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toUpperCase'");
    }

    WebDriver createDriver() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createDriver'");
    }
}
