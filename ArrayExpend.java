public class ArrayExpend{
	public static void main(String [] args){
		int[] a=new int[]{1,2,3,4};
		System.out.println("数组a：");
		arrayPrint(a);
		
		int[] result1=arrayExpend(a);
		System.out.println("扩展结果：");
		arrayPrint(result1);
		System.out.println("after数组a：");
		arrayPrint(a);
		
		int[] result2=arrayExpend2(a);
		System.out.println("扩展结果：");
		arrayPrint(result2);
		System.out.println("after数组a：");
		arrayPrint(a);
	}
	
	public static int[] arrayExpend(int[] a){
		if(a==null){
			return new int[]{};
		}
		//数组引用传递
		int[] temp=a;
		for(int i=0;i<a.length;i++){
			temp[i]=temp[i]*5;
		}
		return temp;
	}
	
	public static int[] arrayExpend2(int[] a){
		if(a==null){
			return new int[]{};
		}
		//空间重新分配
		int[] temp=new int[a.length];
		for(int i=0;i<a.length;i++){
			temp[i]=a[i]*4;
		}
		return temp;
	}
	
	public static void arrayPrint(int[] c){
		if(c==null){
			return ;
		}
	    for(int j=0;j<c.length;j++){
				System.out.print(c[j]+" ");
		}
		System.out.println();
	}
}