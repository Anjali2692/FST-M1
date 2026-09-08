package testRunners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

import io.cucumber.junit.platform.engine.Constants;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("Features")
@ConfigurationParameter( key = Constants.GLUE_PROPERTY_NAME,  value = "stepDefinitions")
@ConfigurationParameter( key = Constants.FILTER_TAGS_PROPERTY_NAME,  value = "@activity3")
  // value = "@activity1
  //value = "@activity2
  //value = "@activity3
//value = "@activity4
//value = "@activity5
//value = "@activity6
@ConfigurationParameter(
		key = Constants.PLUGIN_PROPERTY_NAME,
		value = "pretty, html:Reports/HTML_Report.html, junit:Reports/XML_Report.xml, json:Reports/JSON_Report.json"
	)

public class TestRunner {}
