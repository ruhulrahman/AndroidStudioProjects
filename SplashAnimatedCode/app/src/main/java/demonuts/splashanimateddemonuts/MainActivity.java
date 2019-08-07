package demonuts.splashanimateddemonuts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnF, btnS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnF = (Button) findViewById(R.id.fscreen);
        btnS = (Button) findViewById(R.id.sscreen);

        btnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FirstAnimation.class);
                startActivity(intent);
            }
        });

        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondAnimationActivity.class);
                startActivity(intent);
            }
        });

    }
}
