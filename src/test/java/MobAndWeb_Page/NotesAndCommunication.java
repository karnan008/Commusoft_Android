package MobAndWeb_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import MainPack.Wrapper;

public class NotesAndCommunication extends Wrapper{
	
	public NotesAndCommunication(WebDriver sdriver) 
	{
		this.driverWeb=sdriver;
	}
	
	public void communicationtab() 
	{
		ExplicitWait_PresenceOfEle2("//span[text()='Communications']");
		Webclick("//span[text()='Communications']");
	}
	
	public void AddRecord() 
	{
		WebTwoSec();
		ExplicitWait_ElementToBeClickable2("//a[text()='Add record ']");
		Webclick("//a[text()='Add record ']");
	}
	public void AddNewNote() 
	{
		ExplicitWait_PresenceOfEle2("//span[text()='Add new note']");
		Webclick("//span[text()='Add new note']");
	}
	public void NoteTitle(String webnotetitle) 
	{
		ExplicitWait_PresenceOfEle2("//input[@formcontrolname='title']");
		typeForWeb("//input[@formcontrolname='title']", webnotetitle);
	}
	public void Notes(String webnotes) 
	{
		ExplicitWait_PresenceOfEle2("//textarea[@formcontrolname='note']");
		typeForWeb("//textarea[@formcontrolname='note']", webnotes);
	}
	public void ShareOnMobile() 
	{
		ExplicitWait_PresenceOfEle2("(//span[@class='checkbox-button__control'])[1]");
		Webclick("(//span[@class='checkbox-button__control'])[1]");
	}
	public void Save() 
	{
		ThreeSec();
		ExplicitWait_PresenceOfEle2("//button[text()=' Save ']");
		Webclick("//button[text()=' Save ']");
	}
//	AddRecord
	public void Call() 
	{
		ExplicitWait_PresenceOfEle2("//span[text()='Log new call']");
		Webclick("//span[text()='Log new call']");
	}
	public void Call_To(String mob) 
	{
		WebTwoSec();
		ExplicitWait_PresenceOfEle2("//h4[@class='modal-title']");
		
	    WebElement to = driverWeb.findElement(By.xpath("//select[@formcontrolname='contactTelephoneId']"));
	    Select select = new Select(to);
//	    select.selectByValue("5696");
	    select.selectByVisibleText("44 "+mob);//EditMob
//	    select.selectByIndex(1);
	   
	}
//	Save
//	AddRecord
	public void SendNewEmail() 
	{
		WebTwoSec();
		ExplicitWait_PresenceOfEle2("//span[text()='Send new email']");
		Webclick("//span[text()='Send new email']");
	}
	public void email_To() 
	{
		WebTwoSec();
		ExplicitWait_ElementToBeClickable2("//ul[@class='select2-choices']/li");
		Webclick("//ul[@class='select2-choices']/li");
	}
	public void SelectEmail() 
	{
		WebTwoSec();
		ExplicitWait_PresenceOfEle2("//div[@class='select2-result-label']");
		Webclick("//div[@class='select2-result-label']");
	}
	public void email_Subject(String webemailsub) 
	{
		WebTwoSec();

		WebElement frm = driverWeb.findElement(By.xpath("(//iframe[@id='email-template-subject_ifr'])[1]"));
		driverWeb.switchTo().frame(frm);
		ExplicitWait_ElementToBeClickable2("//p[text()='Subject']");
		Webclick("//p[text()='Subject']");
		WebTwoSec();
		typeForWeb("//body[contains(@onload,'subject')]", webemailsub);
		driverWeb.switchTo().defaultContent();
		
	}
	public void Send() 
	{
		WebTwoSec();
		ExplicitWait_PresenceOfEle2("//button[@class='btn btn-primary']");
		Webclick("//button[@class='btn btn-primary']");
	}
//	AddRecord
	public void SendNewSMS() 
	{
		WebTwoSec();
		ExplicitWait_PresenceOfEle2("//span[text()='Send new sms']");
		Webclick("//span[text()='Send new sms']");
	}
	
	public void sms_To(String mob) 
	{
		WebTwoSec();
        ExplicitWait_PresenceOfEle2("//select[@formcontrolname='contactTelephoneId']");
		
	    WebElement to = driverWeb.findElement(By.xpath("//select[@formcontrolname='contactTelephoneId']"));
	    Select select = new Select(to);
//	    select.selectByValue("5696");
	    select.selectByVisibleText("44 "+mob);
//	    select.selectByIndex(1);
	}
	public void sms_UseTemplate() 
	{
		WebTwoSec();
		ExplicitWait_PresenceOfEle2("//button[text()=' Use template ']");
		Webclick("//button[text()=' Use template ']");
	}
	public void sms_SelectTemplate() 
	{
		WebTwoSec();
		ExplicitWait_PresenceOfEle2("(//span[text()='-- Select --'])[1]");
		Webclick("(//span[text()='-- Select --'])[1]");
	}
//	Send
	
    
	//----------------------------------> Retry Click and Type <-----------------------------------------
	
	
	
}
