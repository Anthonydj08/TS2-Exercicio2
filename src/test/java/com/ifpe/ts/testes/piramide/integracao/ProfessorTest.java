package com.ifpe.ts.testes.piramide.integracao;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.ifpe.excecoes.SiapeInvalidoException;
import com.ifpe.excecoes.TelefoneInvalidoException;
import com.ifpe.facade.Facade;
import com.ifpe.professor.Professor;

public class ProfessorTest {

	Facade facade;
	Professor professor;

	@Before
	public void init() {
		this.facade = new Facade();
		this.professor = new Professor();
	}

	@Test
	public void insertTest() {
		this.professor.setNome("Anthony");
		this.professor.setSiape("546987");
		this.professor.setTelefone("87996555555");
		int status = this.facade.inserirProfessor(this.professor);
		this.facade.removerProfessor("546987");
		assertTrue(status != 0);
	}

	@Test
	public void removeTest() {
		this.professor.setNome("Maria Helena");
		this.professor.setSiape("1565554");
		this.professor.setTelefone("87994526535");
		this.facade.inserirProfessor(professor);
		int status = this.facade.removerProfessor("1565554");
		assertTrue(status != 0);
	}
	
	@Test(expected = SQLException.class)
	public void SQLExceptionTest() throws TelefoneInvalidoException, SiapeInvalidoException, SQLException  {
		this.professor.setNome("Renata Maria");
		this.professor.setSiape("8963156");
		this.professor.setTelefone("87988963264");
		this.facade.inserirProfessor(professor);
		this.facade.inserirProfessor(professor);
        assertTrue(throwException());
	}
	
	private boolean throwException() throws SQLException{
        throw new SQLException();
	}

}