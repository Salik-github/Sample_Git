package com.testingPropse;


import org.testng.annotations.Test;

import com.frameworks.helpers.PropertiesHelpers;

public class ja {
    
    @Test
    public void newMethod()
    {
     
       System.out.println(PropertiesHelpers.getValues("config.properties", "browserType"));
    }
    }

