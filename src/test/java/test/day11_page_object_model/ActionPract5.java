package test.day11_page_object_model;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Hoverpage;
import utilities.Driver09;

/*
TC	#15:	Hover	Test
1.Go	to	http://practice.cybertekschool.com/hovers
2.Hover	over	to	first	image
3.Assert:	a.“name:	user1”	is	displayed
4.Hover	over	to	second	image
5.Assert:	a.“name:	user2”	is	displayed
6.Hover	over	to	third	image
7.Confirm:	a.“name:	user3”	is	display
 */
public class ActionPract5 {
    //we did that task with another way
    //before anything we gonna create a payge from page package .called hoverpage
@Test
    public void tc15_hover()throws InterruptedException{
    Driver09.getDriver().get("http://practice.cybertekschool.com/hovers");
    Hoverpage hoverpage=new Hoverpage();    //from pages package we did that because
    //its 1-easy to maintance  2-re-usable

    //because it needs to moving mouse so we gonna create action
    Actions actions=new Actions(Driver09.getDriver());

    //2.Hover	over	to	first	image
    //3.Assert:	a.“name:	user1”	is	displayed
Thread.sleep(2000);
    actions.moveToElement(hoverpage.img1).perform();
    Assert.assertTrue(hoverpage.user1.isDisplayed());

    Thread.sleep(2000);
    actions.moveToElement(hoverpage.img2).perform();
    Assert.assertTrue(hoverpage.user2.isDisplayed());

    Thread.sleep(2000);
    actions.moveToElement(hoverpage.img3).perform();
    Assert.assertTrue(hoverpage.user3.isDisplayed());
}

}
