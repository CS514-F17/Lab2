package javaanalyzer;
import static org.junit.Assert.*;

import org.junit.Test;

public class JavaAnalyzerErrorTest {

	@Test
	public void testBadParams1() {
		String[] args = {
				"-input",
				"invalid_num_args",
				"-output"
		};
		try {
			Driver.main(args);
			
		} catch(Exception e) {
			fail("Exception thrown for execution with three params: " + e.getMessage());			 
		}
	}

	@Test
	public void testBadParams2() {
		String[] args = {
				"-inpt",
				"input/simple",
				"-output",
				"output/simple.txt"			
		};
		try {
			Driver.main(args);
			
		} catch(Exception e) {
			fail("Exception thrown for execution bad input flag: " + e.getMessage());			 
		}
	}
	
	@Test
	public void testBadParams3() {
		String[] args = {
				"-input",
				"input/simple",
				"-outut",
				"output/simple.txt"			
		};
		try {
			Driver.main(args);
			
		} catch(Exception e) {
			fail("Exception thrown for execution bad output flag: " + e.getMessage());			 
		}
	}


}
