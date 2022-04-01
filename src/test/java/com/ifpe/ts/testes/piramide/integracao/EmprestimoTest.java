package com.ifpe.ts.testes.piramide.integracao;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.sql.Timestamp;

import org.junit.Before;
import org.junit.Test;

import com.ifpe.emprestimo.Emprestimo;
import com.ifpe.excecoes.SiapeInvalidoException;
import com.ifpe.excecoes.TelefoneInvalidoException;
import com.ifpe.facade.Facade;
import com.ifpe.item.Item;
import com.ifpe.professor.Professor;

public class EmprestimoTest {

	Facade facade;
	Timestamp ts;
	Emprestimo emprestimo;
	Professor professor;
	Item item;

	@Before
	public void init() {
		this.facade = new Facade();
		this.ts = new Timestamp(System.currentTimeMillis());
	}

	@Test
	public void insertTest() throws TelefoneInvalidoException, SiapeInvalidoException {
		this.facade.inserirProfessor(this.professor = new Professor("Amanda Moraes", "87996541942", "6522268"));
		this.facade.inserirItem(this.item = new Item("365254", "Mesa"));
		int status = this.facade
				.inserirEmprestimo(this.emprestimo = new Emprestimo("6522268", "365254", this.ts.toString()));
		int id = this.facade.buscarUltimoEmprestimo();
		this.facade.removerEmprestimo(id);
		this.facade.removerProfessor("6522268");
		this.facade.removerItem("365254");
		assertTrue(status != 0);
	}

	@Test
	public void removeTest() throws TelefoneInvalidoException, SiapeInvalidoException {
		this.facade.inserirProfessor(this.professor = new Professor("André Siqueira", "87996541942", "6953652"));
		this.facade.inserirItem(this.item = new Item("482361", "Quadro"));
		this.facade.inserirEmprestimo(this.emprestimo = new Emprestimo("6953652", "652155", this.ts.toString()));
		int id = this.facade.buscarUltimoEmprestimo();
		int status = this.facade.removerEmprestimo(id);
		this.facade.removerProfessor("6953652");
		this.facade.removerItem("652155");
		assertTrue(status != 0);
	}
	
	@Test(expected = SQLException.class)
	public void SQLExceptionTest() throws SQLException, TelefoneInvalidoException, SiapeInvalidoException  {
		this.facade.inserirProfessor(this.professor = new Professor("José", "87935624512", "9852654"));
		this.facade.inserirItem(this.item = new Item("152654", "Telefone"));
		this.facade.inserirEmprestimo(this.emprestimo = new Emprestimo("9852654", "152654", this.ts.toString()));
		this.facade.inserirEmprestimo(this.emprestimo = new Emprestimo("9852654", "152654", this.ts.toString()));
        assertTrue(throwException());
	}
	
	private boolean throwException() throws SQLException{
        throw new SQLException();
	}
}