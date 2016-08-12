package spittr.web;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;

import spittr.data.Spitter;
import spittr.data.SpitterRepository;
import spittr.data.Spittle;
import spittr.data.SpittleRepository;

public class SpitterControllerTest {
	MockMvc mockMvc;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		HomeController controller = new HomeController();
		mockMvc = standaloneSetup(controller).build();
	}

	@After
	public void tearDown() throws Exception {
	}

	
	
	@Test
	public void shouldShowRegistrationForm() throws Exception{
		SpitterRepository mockRepository = mock(SpitterRepository.class);
		SpitterController controller = new SpitterController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller).build();
		
		mockMvc.perform(get("/spitter/register")).andExpect(view().name("registerForm"));
	}

	
	@Test
	public void shouldProcessRegistration() throws Exception {
	    SpitterRepository mockRepository = mock(SpitterRepository.class);
	    Spitter unsaved = new Spitter("Jack", "Bauer","jbauer@test.com", "jbauer", "24hours");
	    Spitter saved = new Spitter(24L, "Jack", "Bauer","jbauer@test.com", "jbauer", "24hours");
	    when(mockRepository.save(unsaved)).thenReturn(saved);

	    SpitterController controller = new SpitterController(mockRepository);
	    MockMvc mockMvc = standaloneSetup(controller).build();

	    mockMvc.perform(post("/spitter/register")
	            .param("firstName", "Jack")
	            .param("lastName", "Bauer")
	            .param("username", "jbauer")
	            .param("password", "24hours"))
	            .andExpect(redirectedUrl("/spitter/jbauer"));

	    //Verified save(unsaved) is called atleast once
	    verify(mockRepository, atLeastOnce());
	}
	

	@Test
	public void testShowSpitter() throws Exception {
		Spitter expectedSpitter = new Spitter("FN12345","LN12345","username12345@test.com","username12345","pwd12345");
		SpitterRepository mockRepository = mock(SpitterRepository.class);
		when(mockRepository.findByUsername("username12345")).thenReturn(expectedSpitter);
		
		SpitterController controller = new SpitterController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller).build();
		
		mockMvc.perform(get("/spitter/username12345")).andExpect(view().name("profile"))
			.andExpect(model().attributeExists("spitter"))
			.andExpect(model().attribute("spitter", expectedSpitter));
		
		
	}
}
