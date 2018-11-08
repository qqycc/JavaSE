//数组运算
public class Statistic{
	public static void main(String [] args){
		int[] a=new int[]{1,2,3,4,5,6};
		int[] result=statistic(a);
		System.out.println("最大值："+result[0]);
		System.out.println("最小值："+result[1]);
		System.out.println("平均值："+result[2]);
	    System.out.println("总和："+result[3]);
    }
	/**
	*int[] array max length =4
	*int[0]:最大值
	*int[1]:最小值
	*int[2]:平均值
	*int[3]:总和
	*/
	public static int[] statistic(int[] a){
		//max、min、avg、sum
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		int avg=0;
		int sum=0;
		if(a==null){
			return new int[]{max,min,avg,sum};
		}
		
		for(int i=0;i<a.length;i++){
            //max
            if(a[i]>max){
                max=a[i];
			}	
            //min
            if(a[i]<min){
                min=a[i];
			}	
            //sum
			sum=sum+a[i];
			//avg
			avg=sum/a.length;
		}
		return new int[]{max,min,avg,sum};
	}
}