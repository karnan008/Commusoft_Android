package New_ui_Testclass;






import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;

import MainPack.Wrapper;

public class GoogleAuthen extends Wrapper{

	public static void main(String[] args) {

	
		GoogleAuthenticator gAuth = new GoogleAuthenticator();
        GoogleAuthenticatorKey key = gAuth.createCredentials();
        
        
        String secretKey = key.getKey();
        System.out.println("Secret Key: " + secretKey);
        
        int code = gAuth.getTotpPassword(secretKey);
        System.out.println("Google Authenticator Code: " + code);

	}

}
