package edu.mum.cs.cs425.lab9.arrayreversor.tddusingstubnmocks;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.mum.cs.cs425.lab9.arrayreversor.tddusingstubnmocks.service.ArrayFlattenerService;

public class ArrayReversorTest {

	private ArrayReversor reversor;
	
	private ArrayFlattenerService flattenService = mock(ArrayFlattenerService.class);

	@Before
	public void setUp() throws Exception {
		this.reversor = new ArrayReversor(flattenService);
	}

	@After
	public void tearDown() throws Exception {
		this.reversor = null;
	}
	
	@Test
	public void testReverseArray() {
		int[][] a_in = new int[][]{{1,3}, {0}, {4,5,9}};
		when(flattenService.flattenArray(a_in)).thenReturn(new int[]{1,3,0,4,5,9});
		int[] arrReversed = reversor.reverseArray(a_in);
		Assert.assertArrayEquals(new int[] {9, 5, 4, 0, 3, 1}, arrReversed);
		verify(flattenService).flattenArray(a_in);
	}
	
	@Test
	public void testReverseArrayNull() {
		int[][] a_in = null;
		when(flattenService.flattenArray(a_in)).thenReturn(null);
		int[] arrReversed = reversor.reverseArray(a_in);
		int[] expected = null;
		Assert.assertArrayEquals(expected, arrReversed);
		verify(flattenService).flattenArray(a_in);
		
	}

}
