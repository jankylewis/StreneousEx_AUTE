package TH_2_10_Team1;

public class FindElementWithXpathAxes {
	
	//PRECEDING <=> FOLLOWING
	String NAV_HOME= "//nav[@id=\"site-navigation\"]//div[@class]//ul[@class=\"sub-menu\"]//preceding::a[contains(text(),\"Home\")]";
	String NAV_TESTING= "//nav[@id=\"site-navigation\"]//div[@class]//ul[@id=\"primary-menu\" or @class=\"menu\"]//li//following::span[text()=\"Testing\"]";
	
	//PRECEDING-SIBLING <=> FOLLOWING-SIBLING
	String LBL_GURU_IS_TOTALLY_NEW= "//div[@class=\"content-wrap\"]//div[@class=\"g-grid\"]//div//div//following-sibling::h3";
	String LBL_SEARCH_FOR_YOUR_FAV_COURSE= "//div[@class=\"content-wrap\"]//div[@class=\"g-grid\"]//div//div//preceding-sibling::h3//following::h4[contains(text(),\"Search\")]";

	//ANCESTOR <=> DESCENDANT
	String NAV_WEB= "//li[@id=\"menu-item-4793\"]//ancestor::li[1][@id=\"menu-item-3175\"]";
	String LBL_APACHE= "//following::li[@id=\"menu-item-4793\"]//descendant::a[@href]";
	
	//PARENT <=> CHILD
	String NAV_BIGDATA= "//li[@id=\"menu-item-3177\"]//child::a//child::span[1][@class=\"nav-drop-title-wrap\"]";
	String DDL_BIGDATA= "//li[@id=\"menu-item-3177\"]//span//parent::a";
	
}
