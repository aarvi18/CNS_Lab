import java.io.*;
import java.util.*;
public class CRC7 {
   public static void main(String[] args)throws IOException {
	Scanner input = new Scanner(System.in);

	int[] data;
	int[] div;
	int[] divisor;
	int[] rem;
	int[] crc;
	int data_bits, divisor_bits, tot_length;

	System.out.println("Enter Number Of Data Bits : ");
	data_bits=input.nextInt();
	data=new int[data_bits];
	System.out.println("Enter Data Bits : ");

	for(int i=0; i<data_bits; i++)
		data[i]=input.nextInt();
		System.out.println("Enter Number Of Bits In Divisor : ");
		divisor_bits=input.nextInt();
		divisor=new int[divisor_bits];
		System.out.println("Enter Divisor Bits : ");

	for(int i=0; i<divisor_bits; i++)
		divisor[i]=input.nextInt();
		tot_length=data_bits+divisor_bits-1;
		div=new int[tot_length];
		rem=new int[tot_length];
		crc=new int[tot_length];

	for(int i=0;i<data.length;i++)
		div[i]=data[i];
		System.out.print("Dividend (After Appending 0's) are : ");

	for(int i=0; i< div.length; i++)
		System.out.print(div[i]);
		System.out.println();

	for(int j=0; j<div.length; j++){
		rem[j] = div[j];
		}
		rem=divide(div, divisor, rem);

	for(int i=0;i<div.length;i++){
		crc[i]=(div[i]^rem[i]);
		}
		System.out.println();
		System.out.println("CRC Code : ");

	for(int i=0;i<crc.length;i++)
		System.out.print(crc[i]);
		System.out.println();
		System.out.println("Enter CRC code of "+tot_length+" Bits : ");

	for(int i=0; i<crc.length; i++)
		crc[i]=input.nextInt();

	for(int j=0; j<crc.length; j++){
		rem[j] = crc[j];
		}

	rem=divide(crc, divisor, rem);

	for(int i=0; i< rem.length; i++)
		{
		if(rem[i]!=0)
			{
			   System.out.println("--ERROR--");
		           break;
			}
		if(i==rem.length-1)
			System.out.println("--NO ERROR--");
		}
		System.out.println("--THANK YOU-- :)");
		}
	static int[] divide(int div[],int divisor[], int rem[])
	{
	int cur=0;
		while(true)
		{
		for(int i=0;i<divisor.length;i++)
			rem[cur+i]=(rem[cur+i]^divisor[i]);
		while(rem[cur]==0 && cur!=rem.length-1)
			cur++;
		if((rem.length-cur)<divisor.length)
			break;
		}
	return rem;
	}
	}
	
















