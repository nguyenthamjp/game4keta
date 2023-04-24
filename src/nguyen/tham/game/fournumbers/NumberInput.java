package nguyen.tham.game.fournumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * class nhập số từ người dùng
 *
 */
public class NumberInput {
	private final int size;
	private final Scanner sc = new Scanner(System.in);
	/**
	 * 
	 * @param size số lượng số cần nhập vào
	 */
	public NumberInput(int size) {
		this.size = size;
	}

	/**
	 * yêu cầu người dùng nhập số
	 * 
	 * @return số được nhập vào
	 */
	public List<Integer> input() {
		
		while (true) {
			// yêu cầu người dùng nhập só vào
			System.out.println(size + "数字を入力してください!");
			final String line = sc.nextLine();
			final List<Integer> numbers = parseNumbers(line);
			if (numbers != null) {
				return numbers;
			}
		}
	}

	/**
	 * chuyển string người dùng nhập vào thành list của các số 0 đến 9, nếu nhập sai
	 * sẽ trả về null
	 * 
	 * @param line string người dùng nhập vào
	 * @return những số người dùng nhập vào hoặc null nếu nhập sai
	 */
	private List<Integer> parseNumbers(String line) {
		if (line.length() != size) {
			// số lượng số nhập vào không khớp = nhập sai: sẽ trả về null
			return null;
		}
		final List<Integer> results = new ArrayList<>();
		for (int i = 0; i < line.length(); i++) {
			// loop tất cả các char của string
			final char c = line.charAt(i);
			if (c < '0' || c > '9') {
				// nếu char nhập vào không phải số từ 0 đến 9 tức là nhập sai, sẽ trả về null
				return null;
			}
			// đúng số từ 0 đến 9 sẽ chuyển char thành int rồi thêm vào kết quả
			final int number = c - '0';
			results.add(number);
		}
		// trả về kết quả
		return results;
	}
}
