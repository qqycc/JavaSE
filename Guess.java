public class Guess{
	public static void main(String[] args){
		GuessNumber guess = new GuessNumber();
		java.util.Random random = new java.util.Random();
	    private final int value =random.nextInt(100);
		guess.guessNumber(value);
	}
}

class GuessNumber{
	//生成随机数value
	public void guessNumber(int value){
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		while(true){
			System.out.println("请输入一个数字：");
			int num = scanner.nextInt();
			if(num>this.value){
				System.out.println("您输入的数字大了");
		    }else if(num<value){
		       	System.out.println("您输入的数字小了");
		    }else{
			    System.out.println("恭喜你猜对了");
			    break;
		    }
	    }
	}
}



