package com.demo.java8;

class RaceCondition {

	public static void main(String[] args) throws InterruptedException {

		LongWrapper longWrapper = new LongWrapper(0L);
		
		Runnable r = () -> {
			
			for (int i = 0 ; i < 1_000 ; i++) {
				longWrapper.incrementValue();
			}
		};
		
		Thread[] threads = new Thread[1_000];
		for (int i = 0 ; i < threads.length ; i++) {
			threads[i] = new Thread(r);
			threads[i].start();
		}
		
		for (int i = 0 ; i < threads.length ; i++) {
			threads[i].join();
		}
		
		System.out.println("Value = " + longWrapper.getValue());
	}
}
