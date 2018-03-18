import java.util.Random;

class genOTP {
	public static void main(String[] args) {
		Random d = new Random();
		int len = 6;
		char[] o = new char[len];
		String n = "0123456789";

		for (int i = 0; i < len; i++) {
			o[i] = n.charAt(d.nextInt(10));
		}
		
		String otp = new String(o);
		System.out.println(otp);
	}
}