package com.ifpe.ts.testes.piramide.unidade;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.ifpe.excecoes.SiapeInvalidoException;
import com.ifpe.excecoes.TelefoneInvalidoException;
import com.ifpe.professor.Professor;

public class ProfessorTest {
	
	Professor professor;

	@Before
	public void init() throws TelefoneInvalidoException, SiapeInvalidoException {
		this.professor = new Professor("André da Rocha", "87981854256", "1234567");
	}
	
	@Test(expected=TelefoneInvalidoException.class )
	public void telefoneInvalidoExceptionTest() throws TelefoneInvalidoException, SiapeInvalidoException {
		this.professor = new Professor("André da Rocha", "ABC81236589", "1234567");
	}
	
	@Test(expected=SiapeInvalidoException.class )
	public void siapeInvalidoExceptionTest() throws TelefoneInvalidoException, SiapeInvalidoException {
		this.professor = new Professor("André da Rocha", "87981854256", "123");
	}
	
	@Test
	public void construtorTest() {
		Professor prof = new Professor();
		assertTrue(prof != null);
	}
	
	@Test
	public void setNomeTest() {
		this.professor.setNome("Maria Andrade Almeida");
		assertTrue(this.professor.getNome().equals("Maria Andrade Almeida"));
	}
	
	@Test
	public void setTelefoneTest() {
		this.professor.setTelefone("87999563269");
		assertTrue(this.professor.getTelefone().equals("87999563269"));
	}
	
	@Test
	public void setsiapeTest() {
		this.professor.setSiape("ABCDEFG");
		assertTrue(this.professor.getSiape().equals("ABCDEFG"));
	}
	
	
}