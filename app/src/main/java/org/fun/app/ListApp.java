package org.fun.app;

import org.fun.ds.helper.ListProxy;

/**
 * Application to demonstrate List operations
 * @author Rakesh Kaim
 */
public class ListApp {
	public static void main(String[] args) {
		ListProxy listProxy = new ListProxy(10);
		listProxy.init();
	}
}
