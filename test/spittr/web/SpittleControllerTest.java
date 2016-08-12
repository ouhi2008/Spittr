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

import spittr.data.Spittle;
import spittr.data.SpittleRepository;

public class SpittleControllerTest {
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
	public void shouldShowRecentSpittles() throws Exception {
		// s1: prepare datas
		List<Spittle> expectedSpittles = createSpittleList(20);
		SpittleRepository mockRepo = mock(SpittleRepository.class);
		when(mockRepo.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedSpittles);

		SpittleController controller = new SpittleController(mockRepo);
		MockMvc mockMvc = standaloneSetup(controller)
				.setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();

		// s2 and s3
		mockMvc.perform(get("/spittles")).andExpect(view().name("spittles"))
				.andExpect(model().attributeExists("spittleList"))
				.andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));
	}

	private List<Spittle> createSpittleList(int count) {
		List<Spittle> spittles = new ArrayList<Spittle>();
		for (int i = 0; i < count; i++) {
			spittles.add(new Spittle("Spittle " + i, new Date()));
		}
		return spittles;
	}
	
	@Test
	public void shouldShowRecentSpittles_NORMAL() throws Exception {
	    List<Spittle> expectedSpittles = createSpittleList(50);
	    SpittleRepository mockRepository = mock(SpittleRepository.class);
	    when(mockRepository.findSpittles(238900, 50))
	            .thenReturn(expectedSpittles);
	    SpittleController controller = new SpittleController(mockRepository);
	    MockMvc mockMvc = standaloneSetup(controller)
	            .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
	            .build();

	    mockMvc.perform(get("/spittles?max=238900&count=50"))
	            .andExpect(view().name("spittles"))
	            .andExpect(model().attributeExists("spittleList"))
	            .andExpect(model().attribute("spittleList",
	                    hasItems(expectedSpittles.toArray())));
	}
	
	@Test
	public void testShowSpittle() throws Exception {
		Spittle expectedSpittle = new Spittle("message12345",new Date());
		SpittleRepository mockRepo = mock(SpittleRepository.class);
		when(mockRepo.findOne(12345)).thenReturn(expectedSpittle);
		
		SpittleController controller = new SpittleController(mockRepo);
		MockMvc mockMvc = standaloneSetup(controller).build();
		
		mockMvc.perform(get("/spittles/12345")).andExpect(view().name("spittle"))
			.andExpect(model().attributeExists("spittle"))
			.andExpect(model().attribute("spittle", expectedSpittle));
		
		
	}
	


}
