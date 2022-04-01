package com.ifpe.ts.testes.piramide.unidade;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.ifpe.item.Item;

public class ItemTest {

	Item item;
	
	@Before
	public void init() {
		this.item = new Item("00536", "Caderno");
	}
	
	@Test
	public void setCodigoTest() {
		this.item.setCodigoItem("00998");
		assertTrue(this.item.getCodigoItem().equals("00998"));
	}
	
	@Test
	public void setTipoItemTest() {
		this.item.setTipoItem("Notebook");
		assertTrue(this.item.getTipoItem().equals("Notebook"));
	}
}