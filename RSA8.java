import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;
public class RSA8 {
	public static void main(String[] args) {

		BigInteger p,q,n,z,e,d;

		byte [] encrypted=new byte[1000];
		byte [] decrypted=new byte[1000];
		int range=128;

		Random random = new Random();
		p=BigInteger.probablePrime(range,random);
		q=BigInteger.probablePrime(range,random);
		e=BigInteger.probablePrime(range, random);
		n=p.multiply(q);
		z=p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

		while(z.gcd(e).compareTo(BigInteger.ONE)>0&& e.compareTo(z)<0)
		{
			e.add(BigInteger.ONE);
			}
			d=e.modInverse(z);
			System.out.println("d: "+d+"\nn: "+n);
			Scanner in=new Scanner(System.in);
			String text;
			System.out.println("Enter the text");
			text=in.nextLine();
			System.out.println("ASCII: "+BytestoString(text.getBytes ()));
			encrypted=encrypt_decrypt(text.getBytes(), e,n,true);
			decrypted=encrypt_decrypt(encrypted,d,n,false);
			System.out.println("Decrypted String: "+new String(decrypted));
		}
	public static String BytestoString(byte[] encrypted)
		{
		String test=" ";
		for(int i=0;i<encrypted.length;i++)
		{
			test=test+encrypted[i]+"";
		}
		return test;
	}

	public static byte[] encrypt_decrypt(byte[] message,BigInteger e,BigInteger n,boolean t)
	{
	BigInteger c=new BigInteger(message).modPow(e,n);
		if(t)
		System.out.println("Cipher Text: "+c);
	return c.toByteArray ();
}
}

//Code by Rakesh Kumar @Ait










