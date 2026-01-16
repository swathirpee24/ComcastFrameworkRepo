package com.comcast.crm.orgtest;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.comcast.crm.BaseTest.BaseClass;
import com.comcast.crm.ObjectRepositoryUtility.CreatingNewOrganizationPage;
import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationInformationPage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationsPage;


public class CreateOrg_with_Testng_test extends BaseClass {
	
	
		
			@Test
			public void createOrgTest()  throws Throwable {
				
				//read test script data from excel file
				
				String orgName=elib.getDataFromExcel("org", 1, 2) + jlib.getRandomNumber();
		
				//step2:navigate organization module
			    driver.findElement(By.linkText("Organizations")).click();
			    
			    //step3:click on "create organization" Button
			    com.cast.crm.objectrepositortutility.HomePage hp = new com.cast.crm.objectrepositortutility.HomePage(driver);
				hp.getOrgLink().click();

				OrganizationsPage cnp = new OrganizationsPage(driver);
				cnp.getCreateNeworgBtn().click();
				
				CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
				cnop.createorg(orgName, "malleshwaram");
			
				          // verify  Header OrgName info Expected Result
				OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		     	String actorgName = oip.getHeaderMsg().getText();
				if(actorgName.contains(orgName)) {
			    	   System.out.println(orgName + "is created == PASS");
			        }
			        else {
			        	System.out.println(orgName + "is not created == FAIL");
			        }
			       }
			
			@Test
			public void createOrgWithPhonenumberTest() throws Throwable {
						// read test script data from excel file

				String orgName = elib.getDataFromExcel("org", 7, 2) + jlib.getRandomNumber();
				String phoneNumber = elib.getDataFromExcel("org", 7, 3);
				
				// step2:navigate organization module
			    HomePage hp = new HomePage(driver);
				hp.getOrglnk().click();

				// step3:click on "create organization" Button
				
				OrganizationsPage cnp = new OrganizationsPage(driver);
				cnp.getCreateNeworgBtn().click();
				CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
				cnop.createorg(orgName, "mallesh", phoneNumber);
			

				// verify the industries and type info
				String actPhonenumber = driver.findElement(By.id("dtlview_Phone")).getText();
				if (actPhonenumber.equals(phoneNumber)) {
					System.out.println(phoneNumber + "information is verified ==PASS");
				} else {
					System.out.println(phoneNumber + "information is not verified == FAIL");
				}
				
			}
			
			@Test
			public void createOrgWithIndusties() throws Throwable {
						// read test script data from excel file

				String orgName = elib.getDataFromExcel("org", 4, 2) + jlib.getRandomNumber();
				String indstries = elib.getDataFromExcel("org", 4, 3);
				
			    //navigate to org
			    HomePage hp = new HomePage(driver);
				hp.getOrglnk().click();
				
				//create org
				OrganizationsPage cnp = new OrganizationsPage(driver);
				cnp.getCreateNeworgBtn().click();
				
				CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
				cnop.createorg1(orgName, "Mallesh", indstries);
				
				//verify industri info
				OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		     	String actindustries = oip.getIndustryinfo().getText();
		     	if (actindustries.equals(indstries)) {
					System.out.println(indstries +   "information is verified ==PASS");
				} else {
					System.out.println(indstries +   "information is not verified == FAIL");
				}
		     
			}
		}


