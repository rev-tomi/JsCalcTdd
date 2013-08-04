package com.tamasrev;

import static org.junit.Assert.assertEquals;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.junit.Before;
import org.junit.Test;

public class TestCalc {

	private ScriptEngine engine;
	
	@Before
	public void setUp() throws Exception {
		ScriptEngineManager factory = new ScriptEngineManager();
		engine = factory.getEngineByName("JavaScript");
		ScriptContext context = engine.getContext();
		context.setAttribute("name", "JavaScript", ScriptContext.ENGINE_SCOPE);
		
		String[] sources = new String[] {
			"/com/tamasrev/Calc.js"	
		};
		for (String src : sources) {
			Reader r = new InputStreamReader(getClass().getResourceAsStream(src));
			engine.eval(r);
		}
	}

	@Test
	public void testSum() throws Exception {
		//GIVEN - nothing to do
		
		//WHEN
		Object result = engine.eval("sum(2, 3)");
		
		//THEN
		assertEquals(5.0, result);
	}
	
	@Test
	public void testDividendAndRemainder() throws Exception {
		//GIVEN
		String source = "dividendWithRemainder(5, 2)";
		
		//WHEN
		Map result = (Map) engine.eval(source);
		
		//THEN
		assertEquals(2.0, result.get("dividend"));
		assertEquals(1.0, result.get("remainder"));
	}
	

}
