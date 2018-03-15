package hostel.fledged;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OTP extends AppCompatActivity {
    EditText otpText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);


        Bundle data = getIntent().getExtras();
        final String otp = data.getString("otp");
        final String phone = data.getString("phone");
        final String usn = data.getString("usn");

        WebView sendURL = findViewById(R.id.webview);

        final Button verifyBtn = findViewById(R.id.button2);

        String url = "http://fledgedorg.000webhostapp.com/index.php?phone="+phone+"&otp="+otp;

        Toast.makeText(getApplicationContext(), otp, Toast.LENGTH_SHORT).show();
//        Toast.makeText(getApplicationContext(), phone, Toast.LENGTH_SHORT).show();
//        Toast.makeText(getApplicationContext(), usn, Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), "Sending OTP via "+url, Toast.LENGTH_LONG).show();

        sendURL.loadUrl(url);

        verifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                otpText = findViewById(R.id.otp);
                if (otpText.getText().toString().equals(otp)) {
                    Toast.makeText(getApplicationContext(), "Generating QR...", Toast.LENGTH_SHORT).show();
                    try {
                        generateQRCode();
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
                    }
                }

                else
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
            }

            private void generateQRCode() {

                Toast.makeText(getApplicationContext(), "Starting QRCode.class...", Toast.LENGTH_SHORT).show();

                //Data to be sent ot the next activity
                Bundle data = new Bundle();

                data.putString("usn", usn);
                data.putString("phone", phone);


                Toast.makeText(getApplicationContext(), "Starting QRCode.class...", Toast.LENGTH_SHORT).show();

                // Start QRCode.class
                Intent generate = new Intent(OTP.this, QRCode.class);

                generate.putExtras(data);
                startActivity(generate);
            }
        });
    }
}
