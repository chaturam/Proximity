package au.com.peercore.proximity;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity implements SensorEventListener {

    SensorManager sManager;
    Sensor mSensor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mSensor = sManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        Log.d("Proximity", "maz: " + mSensor.getMaximumRange());

    }

    protected void onResume() {
        super.onResume();
        sManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        sManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Log.d("Proximity", "Values: " + sensorEvent.values[0]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        if(sensor.getType() == mSensor.getType()){
            //Log.d("Proximity", "Accuracy: " + i);
        }

    }
}
