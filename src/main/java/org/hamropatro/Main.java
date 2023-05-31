package org.hamropatro;


import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

    public static void main(String[] args) throws InterruptedException {
     PropertiesProvider.loadProperties();
        SegmentTest segment=new SegmentTest();
        segment.loginTest();
        segment.createSegment();

        }
    }
