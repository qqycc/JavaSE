import java.util.Arrays;
public class ArrayUtil{
//拷贝
//方法一
    // public static void main(String [] args){
		// int[] src=new int[]{1,2,3,4,5,6,7,8};
		// int[] dest=new int[3];
		// arrayPrint(src);
		// arrayPrint(dest);
		// //方法一
		// // for(int i=2;i<5;i++){
			// // dest[i-2]=src[i];
		// // }
		// //方法二
		// System.arraycopy(src,2,dest,0,3);
		// arrayPrint(src);
		// arrayPrint(dest);
	// }
	
//方法二
    public static void main(String [] args){
		int[] src=new int[]{1,2,3,4,5,6,7,8};
		arrayPrint(src);
		int[] dest1=Arrays.copyOf(src,7);
		arrayPrint(src);
		arrayPrint(dest1);
		int[] dest2=Arrays.copyOf(src,10);
		arrayPrint(dest2);
	}

//排序

	// public static void main(String [] args){
		// char[] a=new char[]{'c','B','z','F'};//B F c z
		// System.out.println("排序之前：");
		// arrayPrint(a);
		// Arrays.sort(a);
		// System.out.println("排序之后：");
		// arrayPrint(a);
	// }
	public static void arrayPrint(char[] c){
		if(c==null){
			return ;
		}
	    for(int j=0;j<c.length;j++){
				System.out.print(c[j]+" ");
		}
		System.out.println();
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