package com.fevly.kasuarixsuanggi;
/*====================================
 Author : fevly pallar
 Contact : fevly.pallar@gmail.com
========================================*/
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.fevly.kasuarixsuanggi.databinding.ActivityMainBinding;
import java.nio.charset.StandardCharsets;
public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("kasuarixsuanggi");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        getCurrentVectorState();
        addElement((byte) 'a');
        addElement((byte) 'b');
        addElement((byte) 'c');

        // Get the updated vector
        byte[] vectorBytes = getCurrentVectorState();
        // Use the vector as needed
        String vectorString = new String(vectorBytes, StandardCharsets.UTF_8);
        Log.d("kasuarixsuanggi", "Vector: " + vectorString);


    }

    public native byte[] getCurrentVectorState();
    public native void addElement(byte newElement);
}