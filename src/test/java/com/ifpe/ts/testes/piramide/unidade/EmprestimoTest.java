package com.ifpe.ts.testes.piramide.unidade;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.ifpe.emprestimo.Emprestimo;

public class EmprestimoTest {

	Emprestimo emprestimo;
	
	@Before
	public void init() {
		this.emprestimo = new Emprestimo("1234ABC", "00002", "01/04/2022");
	}
	
	@Test
	public void setsiapeTest() {
		this.emprestimo.setSiapeProf("ABCD123");
		assertTrue(this.emprestimo.getSiapeProf().equals("ABCD123"));
	}
	
	@Test
	public void setCodigoTest() {
		this.emprestimo.setCodItem("00015");
		assertTrue(this.emprestimo.getCodItem().equals("00015"));
	}
	
	@Test
	public void setDataTest() {
		this.emprestimo.setData("01/04/2022");
		assertTrue(this.emprestimo.getData().equals("01/04/2022"));
	}
}