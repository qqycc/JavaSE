import java.io.IOException;
public class Logic{
	public static void main(String [] args){
		int num=60;
		System.out.println(add(num));
	}

	public static int add(int num){
		if(num==1){
		return 1;
		}else{
			num=num+add(num-1);
		    return num;
		}
	}
	
	public static void mulTable(){
		for(int row=1;row<10;row++){
			for(int col=1;col<=row;col++){
				System.out.print(row+"*"+col+"="+row*col+"\t");
			}
			System.out.println();
		}
	}

	public static void SwitchMethod()throws IOException{
		System.out.println("请输入一个字符：");
		char i=(char)System.in.read();
		switch(i){
			case 'a':{
				System.out.println("Bonjour a!");
			    break;
			}
			case 'b':{
			    System.out.println("Bonjour b!");
			    break;
			}
			default:
			System.out.println(i);
		}
	}
	
    // public static void ifCondition(){
		// String  pgname=args[0];
		// if(pgname.equals("Java")){
			// System.out.println("Java is best");
		// }else if(pgname.equals("MySQL")){
			// System.out.println(pgname+" is better");
		// }else{
			// System.out.println(pgname+" is good");
		// }
	// }

}