package ch.fhnw.mas.swe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author David Herzig
 */
public class MathUtil {
    
	public static void main(String[] args) {
		
		List<Integer> samples = new ArrayList<>();
		samples.add(-20);
		samples.add(0);
		samples.add(3);
		
		System.out.println(max(samples));
		
		
	}
    public static int max(List<Integer> input) {
        int result = input.get(0);
        for (Integer n : input) {
            if (n > result) {
                result = n;
            }
        }
        return result;
    }
    
    public static int min(List<Integer> input) {
        int result = input.get(0);
        for (Integer n : input) {
            if (n < result) {
                result = n;
            }
        }
        return result;
    }
    
    public static double median(List<Integer> input) {
        Collections.sort(input);
        int index = input.size() / 2;
        if (input.size() % 2 == 0) {
            return (input.get(index) + input.get(index-1)) / 2;
        } else {
            return input.get(index);
        }
    }
    
    public static double mean(List<Integer> input) {
        double sum = 0.0;
        for (Integer n : input) {
            sum += n;
        }
        return sum / input.size();
    }
}
