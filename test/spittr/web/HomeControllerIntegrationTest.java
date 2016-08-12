package spittr.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import spittr.config.RootConfig;
import spittr.config.WebConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "webapp")
@ContextHierarchy({
		@ContextConfiguration(name="parent",classes = RootConfig.class),
		@ContextConfiguration(name="child",classes = WebConfig.class)})
public class HomeControllerIntegrationTest {
	@Autowired
	private WebApplicationContext context;
	
	MockMvc mockMvc;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		mockMvc = webAppContextSetup(context).build();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHome() throws Exception {
		mockMvc.perform(get("/")).andExpect(view().name("home"));

	}

}
