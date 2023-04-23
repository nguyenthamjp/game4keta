package nguyen.tham.game.fournumbers;

import java.util.List;

public class Game {
	private final static int SIZE = 4;
	public static void main(String[] args) {
	
		// tạo só 4 chữ só random
		final NumberGenerator numberGenerator = new NumberGenerator(SIZE);
		final List<Integer> numbers = numberGenerator.generate();
		// tạo instance để kiểm tra kết quả
		final NumberVerifier numbersVerifier = new NumberVerifier(numbers);
		// yêu cần người dùng nhập vào cho đến khi đúng
		final NumberInput numberInput = new NumberInput(SIZE);
		while(true) {
			final List<Integer> inputNumbers = numberInput.input();
			if(numbersVerifier.verify(inputNumbers)) {
				// nếu số nhập vào đúng thì ngừng lại
				break;
			}
			// in kết quả nhập ra cho người dùng rồi yêu cầu nhập lại
			System.out.println("間違いました:" + numbersVerifier.getLastVerifiedResult());
		}
		System.out.println("正解です！おめでとうございます！！！");
		System.out.println("やり直し回数：" + numbersVerifier.getVerifiedCount() +"回");
		
	}
}
