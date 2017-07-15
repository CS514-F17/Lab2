package javaanalyzer;

import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;

import org.junit.Test;

public class JavaAnalyzerTest {

	@Test
	public void testSimple() {
		String[] args = {
				"-input",
				"input/simple",
				"-output",
				"output/simple.txt",								
		};
		try {
			Driver.main(args);
			int result = checkFiles(Paths.get("output/simple.txt"), Paths.get("expected/simple.txt"));
			if(result <= 0) {
				fail("Simple test failed -- mismatched line: " + -result);
			}
		} catch(Exception e) {
			fail("Exception thrown for simple test: " + e.getMessage());			 		
		}		
	}

	@Test
	public void testComplex() {
		String[] args = {
				"-input",
				"input/complex",
				"-output",
				"output/complex.txt",								
		};
		try {
			Driver.main(args);
			int result = checkFiles(Paths.get("output/complex.txt"), Paths.get("expected/complex.txt"));
			if(result <= 0) {
				fail("Complex test failed -- mismatched line: " + -result);
			}
		} catch(Exception e) {
			fail("Exception thrown for simple test: " + e.getMessage());			 		
		}		
	}

	//@author sjengle
	public static int checkFiles(Path path1, Path path2) throws IOException {
		Charset charset = java.nio.charset.StandardCharsets.UTF_8;

		// used to output line mismatch
		int count = 0;

		try (
				BufferedReader reader1 =
				Files.newBufferedReader(path1, charset);
				BufferedReader reader2 =
						Files.newBufferedReader(path2, charset);
				) {
			String line1 = reader1.readLine();
			String line2 = reader2.readLine();

			while (true) {
				count++;

				// compare lines until we hit a null (i.e. end of file)
				if ((line1 != null) && (line2 != null)) {
					// use consistent path separators
					line1 = line1.replaceAll(Matcher.quoteReplacement(File.separator), "/");
					line2 = line2.replaceAll(Matcher.quoteReplacement(File.separator), "/");

					// remove trailing spaces
					line1 = line1.trim();
					line2 = line2.trim();

					// check if lines are equal
					if (!line1.equals(line2)) {
						return -count;
					}

					// read next lines if we get this far
					line1 = reader1.readLine();
					line2 = reader2.readLine();
				}
				else {
					// discard extra blank lines at end of reader1
					while ((line1 != null) && line1.trim().isEmpty()) {
						line1 = reader1.readLine();
					}

					// discard extra blank lines at end of reader2
					while ((line2 != null) && line2.trim().isEmpty()) {
						line2 = reader2.readLine();
					}

					if (line1 == line2) {
						// only true if both are null, otherwise one file had
						// extra non-empty lines
						return count;
					}
					else {
						// extra blank lines found in one file
						return -count;
					}
				}
			}
		}
	}
	
	
}

