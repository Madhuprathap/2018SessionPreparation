package com.wissen;

import java.util.*;
import java.util.concurrent.*;

public class Stats {
	
	public static class StatisticsAggregatorImpl implements StatisticsAggregator {
		private Map<String, StockStat> stocksStats = new HashMap<String, StockStat>();
		@Override
		public void putNewPrice(String symbol, double price) {
			synchronized (stocksStats) {
				if (stocksStats.containsKey(symbol)) {
					StockStat temp = stocksStats.get(symbol);
					temp.setCount(temp.getCount()+1);
					temp.setTotalValue(temp.getTotalValue()+price);
				} else {
					stocksStats.put(symbol, new StockStat(1, price));
				}
				
			}
		}

		@Override
		public double getAveragePrice(String symbol) {
			return stocksStats.get(symbol).getTotalValue() / stocksStats.get(symbol).getCount();
		}

		@Override
		public int getTickCount(String symbol) {
			return stocksStats.get(symbol).getCount();
		}
	}

	////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

	public interface StatisticsAggregator {
		// This is an input. Make note of this price.
		public void putNewPrice(String symbol, double price);

		// Get the average price
		public double getAveragePrice(String symbol);

		// Get the total number of prices recorded
		public int getTickCount(String symbol);
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			final StatisticsAggregator stats = new StatisticsAggregatorImpl();
			final Set<String> symbols = new TreeSet<>();

			String line = scanner.nextLine();
			String[] inputs = line.split(",");
			int threads = Integer.parseInt(inputs[0]);
			ExecutorService pool = Executors.newFixedThreadPool(threads);
			for (int i = 1; i < inputs.length; ++i) {
				String[] tokens = inputs[i].split(" ");
				final String symbol = tokens[0];
				symbols.add(symbol);
				final double price = Double.parseDouble(tokens[1]);
				pool.submit(new Runnable() {
					@Override
					public void run() {
						stats.putNewPrice(symbol, price);
					}
				});

			}
			pool.shutdown();
			try {
				pool.awaitTermination(5000, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			for (String symbol : symbols) {
				System.out.println(String.format("%s %.4f %d", symbol,
						stats.getAveragePrice(symbol),
						stats.getTickCount(symbol)));
			}
		}
		scanner.close();

	}
}

class StockStat {
	private int count;
	private Double totalValue;
	
	public StockStat(int count, Double totalValue) {
		super();
		this.count = count;
		this.totalValue = totalValue;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Double getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}
}