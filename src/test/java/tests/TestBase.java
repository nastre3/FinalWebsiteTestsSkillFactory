package tests;

import appmanager.ApplicationManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.BrowserType;

import java.io.IOException;

public class TestBase {
    protected static final ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

    @Before
    public void setUp() throws Exception {
        app.init("");
    }

    @After
    public void tearDown() throws IOException, Exception {
        app.stop();
    }
}
