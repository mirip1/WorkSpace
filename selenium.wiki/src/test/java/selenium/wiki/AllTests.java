package selenium.wiki;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ SeleniumCalculadora.class, SeleniumPruebas.class })
public class AllTests {

}
