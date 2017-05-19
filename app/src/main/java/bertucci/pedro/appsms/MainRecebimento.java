package bertucci.pedro.appsms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class MainRecebimento extends BroadcastReceiver {

    private String TAG = MainRecebimento.class.getSimpleName();
    private String NUMBER_FILTER = "5555";

    public void onReceive(Context context, Intent intent) {
        Log.e(TAG, "Receiver activated");

        Bundle extraContent = intent.getExtras();
        Object[] messagePdus = (Object[]) extraContent.get("teste");
        SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) messagePdus[0]);

        if (smsMessage.getOriginatingAddress().endsWith(NUMBER_FILTER)) {
            Log.e(TAG, "Message intercepted: "+ smsMessage.getMessageBody());
            abortBroadcast();
        }
    }
}
