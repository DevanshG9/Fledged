package hostel.fledged;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import net.glxn.qrgen.core.scheme.VCard;

public class QRCode extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        // Get the view from new_activity.xml
        setContentView(R.layout.display_qr);

        Bundle credentials = getIntent().getExtras();

        String usn = credentials.getString("usn");
        String phone = credentials.getString("phone");

        VCard details = new VCard(usn)
                .setPhoneNumber(phone);

        Bitmap code = net.glxn.qrgen.android.QRCode.from(details).withSize(250, 250).bitmap();
        ImageView barCode = findViewById(R.id.imageView);
        barCode.setImageBitmap(code);
    }
}
