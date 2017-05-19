package bertucci.pedro.appsms;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button buttonSend, btnRelatorio;
    EditText textPhoneNo;
    EditText textSMS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSend = (Button) findViewById(R.id.button);
        btnRelatorio = (Button) findViewById(R.id.btnRelatorio);
        textPhoneNo = (EditText) findViewById(R.id.edtNumero);
        textSMS = (EditText) findViewById(R.id.edtMsg);

        btnRelatorio.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                Intent intent = new Intent();
                MainRecebimento  recebimento = new MainRecebimento();
                recebimento.onReceive(context,intent);
            }
        });

        buttonSend.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String phoneNo = textPhoneNo.getText().toString();
                String sms = textSMS.getText().toString();

                try {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNo, null, sms, null, null);
                    Toast.makeText(getApplicationContext(), "SMS Enviado!",
                            Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),
                            "Falha ao enviar SMS!",
                            Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }

            }
        });
    }



}
