package edu.mum.cs.cs425.lab9.arrayreversor.tddusingstubnmocks;

import edu.mum.cs.cs425.lab9.arrayreversor.tddusingstubnmocks.service.ArrayFlattenerService;

public class ArrayReversor {

	private ArrayFlattenerService flattenService;
	
	
	
	public ArrayReversor(ArrayFlattenerService flattenService) {
		super();
		this.flattenService = flattenService;
	}



	public int[] reverseArray(int[][] arr) {
		
		int[] flat = flattenService.flattenArray(arr);
		int[] res = new int[flat.length];
		for(int i = 0; i < flat.length; i++) {
			res[i] = flat[flat.length - 1 - i];
		}
		
		return res;
		
	}
}
