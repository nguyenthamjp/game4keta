package nguyen.tham.game.fournumbers;

import java.util.List;

public class NumberVerifier {
	/**
	 * Số để so sánh
	 */
	private final List<Integer> numbers;
	/**
	 * Số lần kiểm tra
	 */
	private int verifiedCount = 0;
	/**
	 * Số lần kiểm tra
	 */
	public int getVerifiedCount() {
		return verifiedCount;
	}
	/**
	 * kết quả lần kiẻm tra cuối
	 */
	private String lastVerifiedResult;
	/**
	 * kết quả lần kiẻm tra cuối
	 */
	public String getLastVerifiedResult() {
		return lastVerifiedResult;
	}
	
	public NumberVerifier(List<Integer> numbers) {
		this.numbers = numbers;
	}
	
	/**
	 * kiểm tra số [input] được người dùng nhập vào
	 * @param input số người dùng nhập vào
	 * @return kết quả
	 * - true: số nhập vào đúng
	 * - false: số nhập vào sai
	 */
	public boolean verify(List<Integer> input) {
		// tăng số lần kiểm tra
		verifiedCount++;
		boolean result = true;
		final StringBuilder results = new StringBuilder();
		for(int i = 0; i< input.size();++i) {
			final int number = input.get(i);
			// kiểm tra số tại vị trí i
			final char c = verify(number, i);
			// thêm kết quả tại vị trí i vào kết quả cuối
			results.append(c);
			if(c != '〇') {
				// nếu số tại vị trí i bị sai, thì kết quả cuối cùng cũng sai (false)
				result = false;
			}
		}
		lastVerifiedResult = results.toString();
		return result;
	}
	
	/**
	 * kiểm tra số tại vị trí index
	 * @param number số cần kiểm tra
	 * @param index vị trí của số cần kiểm tra
	 * @return kết quả
	 * - đúng số, đúng vị trí: 〇
	 * - đúng số, sai vị trí: △
	 * - sai số: ×
	×
	 */
	private char verify(int number, int index) {
		if(numbers.get(index) == number) {
			// nếu number giống với số ở cùng vị trí với nó thì tra về 〇
			return '〇';
		}
		if(numbers.contains(number)) {
			// nếu trong numbers có chứa số number thì trả về △
			return '△';
		}
		// trường hợp còn lại (không có số number trong numbers) thì trả về ×
		return '×';
	}

}
