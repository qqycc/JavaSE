public class ArrayTest{
	
	public static void main(String [] args){
		int[] a=new int[]{2,4,6,8};
		int[] b=new int[]{1,3,5,7,9};
		int[] c = arrayJoin(a,b);
		for(int j=0;j<c.length;j++){
				System.out.print(c[j]+" ");
			}
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
	
	public static void staticInit(String [] args){
		int[][] a=new int[][]{{1,2},{3,5,6,4,1},{8,9,7}};
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[i].length;j++){
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	public static void arrayPrint(int[][] a){
	for(int i=0;i<a.length;i++){
			for(int j=0;j<a[i].length;j++){
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	public static void dynamicInit(String [] args){
		int[][] a=new int[2][3];
		a[0][0]=2;
		a[1][2]=5;
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[i].length;j++){
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	public static int[] arrayJoin(int[] a,int[] b){
		//动态初始化
		int[] c=new int [a.length+b.length];
		for(int i=0;i<a.length;i++){
			c[i]=a[i];
		}
		for(int i=a.length;i<c.length;i++){
			c[i]=b[i-a.length];
		}
		return c;
	}
	
	// public static void anonymousarray(){
		// system.out.println(new int[]{1,2,3}.length);
	// }
	// public static void arrayinit(){
		// //基本类型实例化后，在该内存空间的值就是默认值
		// int[] data = new int[5];
		// for(int i=0;i<5;i++){
			// system.out.println(data[i]);
		// }
		// //引用类型默认值为null
		// string[] s=new string[5];
		// for(int j=0;j<s.length;j++){
			// System.out.println(s[j]);
		// }
	// }
}