/**
 * 
 */
package nguyen.tham.game.fournumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberGenerator {
	private final int size;
	/**
	 * @param size số các chữ số muốn tạo
	 */
	public NumberGenerator(int size) {
		this.size = size;
	}
	/**
	 * tạo 1 chuối các số random không trùng nhau
	 * @return kết quả
	 */
	public List<Integer> generate(){
		// tạo 1 set để chứa các số không trung nhau được
		// dùng LinkedHashSet dể thứ tự của các cố add vào không bị thay đổi
		final List<Integer> numbers = new ArrayList<>();
		final Random random = new Random();
		// lặp lại cho đến khi đủ số chữ số muốn tạo
		while(numbers.size() < size) {
			// tạo 1 số random từ 0 ~ 9
			final int number = random.nextInt(10);
			if(!numbers.contains(number)) {
				// nếu trong numbers chưa có số number thì thêm số đó vào numbers
				numbers.add(number);
			}
		}
		return numbers;
	}
}
