package testcase;


import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import action.BaseClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.Customer;
import pages.Diary;
import pages.Estimate;
import pages.Job;

public class Checking extends BaseClass{
	
	
	@Test (priority =7)
	public void Create_2Job() throws InterruptedException
	{
		Thread.sleep(10000);
		Customer customer = new Customer(driver);
		Estimate estimate = new Estimate(driver);
		Job job = new Job(driver);
		customer.Side_Menu();
		customer.Customer_search();
		customer.Customer_Searchtext(CustomerName);
		MobileEnter();
		customer.Customer_1select(TitleCustomerName);
		customer.Customer_More();
		customer.Customer_Ongoing();
		customer.Customer_PlusBtn();
		job.Add_New_Job();
		job.Click_Des();
		job.Job_Des(JobDescription);
		scrolltothetop(500,1800,500,400);
		job.Book_Diary_Job();
		Savebtn();
//		swipe(driver, DIRECTION.LEFT);
		//scrolltothetop(500,500,500,2400);//simulator
		scrolltothetop(500,400,500,1800);
		doubleclickpoint(500,900);
		//doubleclickpoint(500,1200);//simulator
		estimate.Book_Event();
		estimate.Savebtn();
	}
	@Test (priority=8)
	public void Job2_FOC() throws InterruptedException
	{
		Thread.sleep(10000);
		Job job = new Job(driver);
		Diary diary = new Diary(driver);
		clickpoint(350, 2021);
		//clickpoint(500, 1200);//simulator
		diary.Diary_Accept();
		diary.Diary_Travel();
		diary.Diary_Arrive();
		job.Arrive_Question();
		job.Sign_save();
		signature(250, 1380, 550, 1220);
		//signature(300, 1500, 1000, 1400);//simulator
		job.Sign_save();
		job.Job_Report();
		job.Leave_Question();
		job.Sign_save();
		job.Job_Leave();
		job.Complete_Continue();
		scrolltothetop(500,1800,500,400);
		signature(272, 1517, 600, 1373);
		//signature(272, 1800, 800, 1870);//simulator
		job.Sign_save();
		signature(300, 1016, 600, 920);
		//signature(300, 1200, 800, 920);//simulator
		job.Sign_save();
		job.FOC();
		job.FOC_Reason();
		job.FOC_Comment();
		job.Sign_save();
		job.Job_Final_Diary();
	}
		
	}


