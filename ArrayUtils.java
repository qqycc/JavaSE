public class ArrayUtils{
	
	//1.计算数组中最大值
	public static int arrayMaxElement(int[] data){
		if(data==null){
			throw new IllegalArgumentException("data must be not null");
		}
		int max=Integer.MIN_VALUE;
		for(int i=0;i<data.length;i++){
			if(data[i]>max){
				max=data[i];
			}
		}
		return max;
	}
	
	//2.最小值
	public static int arrayMinElement(int[] data){
		if(data==null){
			throw new IllegalArgumentException("data must be not null");
		}
		int min=Integer.MAX_VALUE;
		for(int i=0;i<data.length;i++){
			if(data[i]<min){
				min=data[i];
			}
		}
		return min;
	}
		
	//3.数组值之和
	public static int arrayElementSum(int[] data){
		if(data==null){
			throw new IllegalArgumentException("data must be not null");
		}
		int sum=0;
		for(int i=0;i<data.length;i++){
			sum=data[i]+sum;
		}
		return sum;
	}
	
	//4.数组拼接
	public static int[] arrayJoin(int[] a,int[] b){
		if(a==null){
			throw new IllegalArgumentException("data must be not null");
		}
		if(b==null){
			throw new IllegalArgumentException("data must be not null");
		}
		int[] c=new int[a.length+b.length];
		for(int i=0;i<a.length;i++){
			c[i]=a[i];
		}
		for(int i=a.length;i<c.length;i++){
			c[i]=b[i-a.length];
		}
		return c;
	}
	
	//5.数组截取
	//[start,end)
	public static int[] arraySub(int[] a,int start,int end){
		if(a==null){
			throw new IllegalArgumentException("data must be not null");
		}
		if(start<0||end<0){
			throw new IllegalArgumentException("start or end must be>0.");
		}
		if(end<start){
			throw new IllegalArgumentException("end>start");
		}
		if(start>=a.length){
			throw new IllegalArgumentException("start must be <a.length");
		}
		if(end-start>a.length){
			throw new IllegalArgumentException("end-start must be<a.length");
		}
	    int[] c=new int[end-start];
		for(int i=start;i<end;i++){
			c[i-start]=a[i];
		}
		return c;
	}
	
	public static void arrayPrint(int[] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]);
		}
		System.out.println();
	}
		
	public static void main(String [] args){
		int[] a=new int[]{1,3,4,5,6};
		int[] b=new int[]{7,8};
		System.out.println(arrayMaxElement(a));
		System.out.println(arrayMinElement(a));
		System.out.println(arrayElementSum(a));
		arrayPrint(arrayJoin(a,b));
		arrayPrint(arraySub(a,1,4));	
	}
}