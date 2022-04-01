package com.ifpe.ts.testes.piramide.integracao;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.ifpe.facade.Facade;
import com.ifpe.item.Item;

public class ItemTest {
	
	Facade facade;
	Item item;
	
	@Before
	public void init(){
		this.facade = new Facade();
	}
	
	
	@Test
	public void insertTest() {
		int status = this.facade.inserirItem(this.item = new Item("123456", "Smartphone"));
		this.facade.removerItem("123456");
		assertTrue(status != 0);
	}
	
	@Test
	public void removeTest() {
		this.facade.inserirItem(this.item = new Item("894984156", "Ar Condicionado"));
		int status = this.facade.removerItem("894984156");
		assertTrue(status != 0);
	}
	
	@Test(expected = SQLException.class)
	public void SQLExceptionTest() throws SQLException  {
		this.facade.inserirItem(this.item = new Item("99241215", "Fone de ouvido"));
		this.facade.inserirItem(this.item = new Item("99241215", "Fone de ouvido"));
        assertTrue(throwException());
	}
	
	private boolean throwException() throws SQLException{
        throw new SQLException();
	}

}