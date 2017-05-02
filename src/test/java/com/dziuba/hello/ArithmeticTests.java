package com.dziuba.hello;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

public class ArithmeticTests {

    Evaluator ev = new Evaluator();

    @Test
    public void sequanceTest() throws EvaluationException {
	assertEquals("6.0", ev.evaluate("2+2*2"));
    }

    @Test
    public void sequanceTest2() throws EvaluationException {
	assertEquals("8.0", ev.evaluate("(2+2)*2"));
    }

    @Test
    public void sequanceTest3() throws EvaluationException {
	assertEquals("6.0", ev.evaluate("(2+2*2)"));
    }

    @Test
    public void divTest() throws EvaluationException {
	assertEquals("6.0", ev.evaluate("36*6/12/3"));
    }

    @Test
    public void divByZeroTest() throws EvaluationException {
	assertEquals("Infinity", ev.evaluate("1/0"));
    }

}