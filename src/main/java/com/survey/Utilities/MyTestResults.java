package com.survey.Utilities;

import com.aventstack.extentreports.reporter.FileUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.survey.Utilities.AppiumDriverInitialization.getDriver;

public class MyTestResults {


    public static void takescreenshot() {

        File srcfile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        String filePath;
        String patteren = "MM/dd/yyyy HH:mm:ss";
        DateFormat df = new SimpleDateFormat(patteren);
        Date today = Calendar.getInstance().getTime();
        String todayAsString = df.format(today);
        String strDate = todayAsString.replaceAll("\\s", "");
        strDate = strDate.replaceAll("/", "");
        strDate = strDate.replaceAll(":", "");
        filePath = "target/Screenshots/"+strDate+" "+GlobalVariables.ScenarioName+".jpg";
        File DestFile = new File(filePath);
        try{
            FileUtils.copyFile(srcfile, DestFile);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
