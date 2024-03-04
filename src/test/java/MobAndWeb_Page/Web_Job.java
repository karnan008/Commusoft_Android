package MobAndWeb_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import MainPack.Wrapper;

public class Web_Job extends Wrapper{
	
	public Web_Job(WebDriver sdriver) 
	{
		this.driverWeb=sdriver;
	}
	
	public void AddNewJob() 
	{
		ExplicitWait_PresenceOfEle2("//span[text()='Add new job']");
		Webclick("//span[text()='Add new job']");
	}
	
	public void job_Description() 
	{
		ExplicitWait_PresenceOfEle2("//div[@id='s2id_selectJDID']");
	    Webclick("//div[@id='s2id_selectJDID']");	
	}
	
	public void Select_Job(String automationNewQuestionTemplate) 
	{
		WebThreeSec();
		ScrollWeb("//div[text()='"+automationNewQuestionTemplate+"']");
		ExplicitWait_PresenceOfEle2("//div[text()='"+automationNewQuestionTemplate+"']");
		Webclick("//div[text()='"+automationNewQuestionTemplate+"']");
	}
	public void Select_Job2(String automationOldQuestionTemplate) 
	{
		WebThreeSec();
		ScrollWeb("//div[text()='"+automationOldQuestionTemplate+"']");
		ExplicitWait_PresenceOfEle2("//div[text()='"+automationOldQuestionTemplate+"']");
		Webclick("//div[text()='"+automationOldQuestionTemplate+"']");
	}
	
	public void DiaryEventCheckbox() 
	{
		ExplicitWait_PresenceOfEle2("//input[@name='bookDiaryEvent']");
		Webclick("//input[@name='bookDiaryEvent']");
	}
	
	public void SaveJob() 
	{
		ExplicitWait_PresenceOfEle2("//span[text()='Add job']");
		Webclick("//span[text()='Add job']");
		
	}
	
	public void StoreJobNumber() 
	{
		ExplicitWait_PresenceOfEle2("//span[@ng-if='jobId']");
		jobnumber = driverWeb.findElement(By.xpath("//span[@ng-if='jobId']")).getText();
	    System.setProperty("jobnumber", jobnumber);
		System.out.println("Web Estimate Number is: "+jobnumber);
		
	}
	
	
	
	

}
