package com.yantra.auto.yrms.driver.listeners;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;
import com.yantra.auto.yrms.driver.GlobalSettings;

public class ExtentReporterNG implements IReporter {
    public ExtentReports extent;

    private void buildTestNodes(IResultMap testMap, LogStatus status) {
        ExtentTest test;
        

        if (testMap.size() > 0) {
            for (ITestResult result : testMap.getAllResults()) {
                //test = extent.startTest(result.getInstance().getClass().getSimpleName(),result.getMethod().getMethodName());
                test = extent.startTest(result.getMethod().getMethodName().toUpperCase(), result.getInstance().getClass().getSimpleName().toUpperCase());
                test.assignAuthor("Adhithya Srinivasan");
                test.assignCategory(result.getInstance().getClass().getSimpleName().toUpperCase());
                test.setStartedTime(getTime(result.getStartMillis()));
                for (String group : result.getMethod().getGroups())
                    test.assignCategory(group);
                String message = "Test " + status.toString().toLowerCase() + "ed";
                if (result.getThrowable() != null)
                    message = result.getThrowable().getMessage();
                test.setEndedTime(getTime(result.getEndMillis()));
                test.log(status, message);
                extent.endTest(test);
            }
        }
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }

    public void generateReport(List<XmlSuite> xmlsuite, List<ISuite> suites, String file) {
        final String filePath = "./report"+File.separator+"ExtentReport.html";
        extent = new ExtentReports(filePath, true, DisplayOrder.NEWEST_FIRST, NetworkMode.ONLINE);
        extent.loadConfig(new File("src/main/resources/extentConfig.xml"));
        for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();
            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();
                buildTestNodes(context.getPassedTests(), LogStatus.PASS);
                buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
                buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
                buildTestNodes(context.getFailedConfigurations(), LogStatus.FAIL);
                buildTestNodes(context.getSkippedConfigurations(), LogStatus.SKIP);
            }
        }
        extent.flush();
        extent.close();
    }
}
