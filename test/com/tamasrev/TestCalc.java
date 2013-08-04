package com.tamasrev;

import static org.junit.Assert.fail;

import java.io.InputStreamReader;
import java.io.Reader;

import org.junit.Before;
import org.junit.Test;

public class TestCalc {

	@Before
	public void setUp() throws Exception {
		String[] sources = new String[] {
			"/com/tamasrev/Calc.js"	
		};
		for (String src : sources) {
			Reader r = new InputStreamReader(getClass().getResourceAsStream(src));
		}
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
