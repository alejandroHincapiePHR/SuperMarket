package com.SuperMarket.SuperMarket.domain.finance.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private double parameterValue;
    public ConfigReader() {
    }
    public void loadConfig(String configFile, String parameter) {
        Properties prop = new Properties();
        try (FileInputStream input = new FileInputStream(configFile)) {
            prop.load(input);
            String stringParameterValue = prop.getProperty(parameter);
            parameterValue = Double.parseDouble(stringParameterValue);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public double getParameterValue() {
        return parameterValue;
    }


}
