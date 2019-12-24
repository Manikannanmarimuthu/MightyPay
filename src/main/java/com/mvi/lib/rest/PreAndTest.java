 package com.mvi.lib.rest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.mvi.lib.utils.HTMLReporter;

public class PreAndTest extends HTMLReporter {


	@BeforeSuite
	public void beforeSuite() {
		startReport();
	}

	@BeforeClass
	public void beforeClass() {
		startTestCase(testCaseName, testDescription);
	}

	@BeforeMethod
	public void beforeMethod() {
		svcTest = startTestModule(nodes);
		svcTest.assignAuthor(author);
		svcTest.assignCategory(category);
	}

	@AfterMethod
	public void afterMethod() {
	}

	@AfterSuite
	public void afterSuite() {
		endResult();
	}

	@Override
	public long takeSnap() {
		return 0;
	}

}
