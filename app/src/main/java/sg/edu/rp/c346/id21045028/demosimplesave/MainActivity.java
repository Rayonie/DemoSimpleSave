package sg.edu.rp.c346.id21045028.demosimplesave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    protected void onPause() {
        super.onPause();
        //Obtain the SharedPref instance
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        //Create a SharedPref Editor by calling edit()
        SharedPreferences.Editor prefEdit = prefs.edit();
        //Set a key-value pair in the editor
        prefEdit.putString("greetings","Hello!");
        //Call commit to save the changes made to the SharedPref
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        //Obtain the SharedPref instance
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        //Retrieve the saved data from SharedPref
        // with the default value if no matching data
        String msg = prefs.getString("greetings","no greetings name");
        Toast toast = Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG);
        toast.show();
    }
}