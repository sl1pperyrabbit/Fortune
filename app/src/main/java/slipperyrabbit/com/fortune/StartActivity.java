package slipperyrabbit.com.fortune;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class StartActivity extends AppCompatActivity {

    Button useAsGuestButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        useAsGuestButton = (Button)findViewById(R.id.UseAsGuestButton);
        useAsGuestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SignsActivity.class);
                startActivity(i);
            }
        });
    }
}
