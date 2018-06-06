package com.orez.teamup.teamup;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class MenuActivity extends Activity {

    ImageButton mprofileBtn;
    ImageButton msignoutBtn;
    User user;
    Button mWorkBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent i=getIntent();
        user=(User) i.getSerializableExtra("User");
        mprofileBtn=(ImageButton) findViewById(R.id.menu_profileBtn);
        msignoutBtn=(ImageButton) findViewById(R.id.menu_signoutBtn);
        mWorkBtn = (Button) findViewById(R.id.workBtn);
        //Daca apesi pe profil, te duce la profil
        mprofileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, ProfileActivity.class);
                i.putExtra("User", user);
                startActivity(i);
            }
        });


        mWorkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, ResultsActivity.class);
                startActivity(i);
            }
        });
        msignoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                setResult(Activity.RESULT_OK);
                Intent i=new Intent(MenuActivity.this,LoginActivity.class);
                startActivity(i);
                finish();

            }
        });
    }

    public void loadSportsActivity(View view) {
        Intent i = new Intent(MenuActivity.this, SportsActivity.class);
        startActivity(i);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

}
