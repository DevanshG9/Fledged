package hostel.fledged;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;

public class Verification extends AppCompatActivity {

    EditText mUSN, mPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        final Button sendVerificationBtn = findViewById(R.id.button);
        mUSN = findViewById(R.id.usn);
        mPhone = findViewById(R.id.phone);

        sendVerificationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    sendVerificationNumber();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.toString(),
                            Toast.LENGTH_SHORT).show();                }
            }

            private void sendVerificationNumber() throws IOException {
                String usn = mUSN.getText().toString(), phone = mPhone.getText().toString(), otp = getRandom();
                Bundle otpData = new Bundle();

                // Bundling data to be transferred...

                otpData.putString("phone", phone);
                otpData.putString("otp", otp);
                otpData.putString("usn", usn);

                Intent i = new Intent(Verification.this, OTP.class);

                i.putExtras(otpData);

                startActivity(i);
            }
        });
}

   private static String getRandom(){
        boolean done=false;
        String n;
        do {
            n = Integer.toString((int)(Math.random()*1000000));
            if(n.charAt(0)!='0' && n.length()==6){
                done=true;
            }
        } while(!done);
      
}
}
