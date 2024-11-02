package fr.fidtec.tests;

import org.junit.jupiter.api.*;
import org.opentest4j.AssertionFailedError;

//import org.junit.jupiter.api.Assertions; // NOSONAR
import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.Assumptions; // NOSONAR
import static org.junit.jupiter.api.Assumptions.*;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

// https://www.baeldung.com/junit-5
// https://www.baeldung.com/junit-5-migration
// Junit 5 : java 8+ + tests en // + grande granularité dans les imports (JUnit Platform + JUnit Vintage)
// The most important one is that we can no longer use the @Test annotation for specifying expectations
// @Test(expected = Exception.class) don't exist anymore : use assertThrows
// idem timeout
class JupiterBasicTest {

	@BeforeEach // remplace Junit4 @Before
	void BeforeEach() {
		System.out.println("BeforeEach");
	}
	
	@AfterEach  // remplace Junit4 @After
	void AfterEach() {
		System.out.println("AfterEach");
	}
	
	@BeforeAll // remplace Junit4 @BeforeClass
	static void BeforeAll() {
		System.out.println("BeforeAll");
	}
	
	@AfterAll  // remplace Junit4 @AfterClass
	static void AfterAll() {
		System.out.println("AfterAll");
	}

	@Disabled("Ceci est un test désactivé") // @Ignore Junit4
	void Disabled() {
		System.out.println("Disabled");
	}

	@Test
	void shouldSuccessBecauseTimeout1() {
		Assertions.assertTimeout(Duration.ofMillis(50), () -> Thread.sleep(10)); // NOSONAR
	}

	@Test
	@Timeout(value = 50, unit = TimeUnit.MILLISECONDS)
	void shouldSuccessBecauseTimeout2() throws InterruptedException {
		Thread.sleep(10); // NOSONAR
		// fail(); // fait planter le TU
	}

	@Test
	void shouldFailBecauseTimeout1() {
		Assertions.assertThrows( AssertionFailedError.class, () -> Assertions.assertTimeout(Duration.ofMillis(1), () -> Thread.sleep(10))); // NOSONAR
	}

	// assertAll : group assertions in JUnit 5
	@Test
	void shouldAssertAllTheGroup() {
	    List<Integer> list = Arrays.asList(1, 2, 4);
	    assertAll("List is not incremental",
	        () -> Assertions.assertEquals(1, list.get(0).intValue()),
	        () -> Assertions.assertEquals(2, list.get(1).intValue()),
	        () -> Assertions.assertEquals(4, list.get(2).intValue())
	    );
	}
	
	@Test
	void whenEnvironmentIsWeb_thenUrlsShouldStartWithHttp() {
		
		String address = "http://127.0.0.1";
		
	    assumingThat("WEB".equals(System.getenv("ENV")),
	      () -> assertTrue("https".startsWith(address)));
	}
}
