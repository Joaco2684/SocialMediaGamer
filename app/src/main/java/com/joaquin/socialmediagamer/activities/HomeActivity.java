package com.joaquin.socialmediagamer.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.auth.User;
import com.joaquin.socialmediagamer.R;
import com.joaquin.socialmediagamer.fragments.ChatsFragment;
import com.joaquin.socialmediagamer.fragments.FiltersFragment;
import com.joaquin.socialmediagamer.fragments.HomeFragment;
import com.joaquin.socialmediagamer.fragments.ProfileFragment;
import com.joaquin.socialmediagamer.providers.AuthProvider;
import com.joaquin.socialmediagamer.providers.TokenProvider;
import com.joaquin.socialmediagamer.providers.UserProvider;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigation;

    private TokenProvider mTokenProvider;
    private AuthProvider mAuthProvider;
    private UserProvider mUserProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        mTokenProvider = new TokenProvider();
        mAuthProvider = new AuthProvider();
        mUserProvider = new UserProvider();

        openFragment(new HomeFragment());

        createToken();

    }

    @Override
    protected void onStart() {
        super.onStart();
        updateOnline(true);
    }

    @Override
    protected void onStop() {
        super.onStop();
        updateOnline(false);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ENTRO", "ON PAUSE");
    }

    private void updateOnline(boolean status) {
        mUserProvider.updateOnline(mAuthProvider.getUid(), status);

    }

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.itemHome:
                            openFragment(new HomeFragment());
                            return true;
                        case R.id.itemChat:
                            openFragment(new ChatsFragment());
                            return true;
                        case R.id.itemFilters:
                            openFragment(new FiltersFragment());
                            return true;
                        case R.id.itemProfile:
                            openFragment(new ProfileFragment());
                            return true;
                    }
                    return true;
                }
            };

    private void createToken () {
        mTokenProvider.create(mAuthProvider.getUid());
    }
}