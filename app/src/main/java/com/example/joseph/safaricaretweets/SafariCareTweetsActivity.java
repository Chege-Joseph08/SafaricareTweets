package com.example.joseph.safaricaretweets;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

public class SafariCareTweetsActivity extends AppCompatActivity {

    Button   tweet;
    EditText message;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safari_care_tweets);

        tweet=(Button)findViewById(R.id.tweetbtn);
        message=(EditText)findViewById(R.id.messagetxt);

        String token ="966661463069863936-A74ZjI5LhdHi75DKnYfR9EBr6ng8L8g";
        String secret = "1dDSNk0j5oLJ7vDUmy2gArW6DpG0RKs1w6wxA49b7Ccoo";
        AccessToken a = new AccessToken(token,secret);
        final Twitter twitter = new TwitterFactory().getInstance();
        twitter.setOAuthConsumer("p2EF2xSR6pSVYKaOeVvs675SZ", "5v0rQgA2d4A2wjeSJFweInDLRAh5zTQkwz6NNiOOzHwKgLZb5O");
        twitter.setOAuthAccessToken(a);


        tweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

//                https://stackoverflow.com/questions/18395254/login-twitter-to-show-the-error-android-os-networkonmainthreadexception

                if (android.os.Build.VERSION.SDK_INT> 8) {
                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                            .permitAll().build();
                    StrictMode.setThreadPolicy(policy);
                }
                try {
                    twitter.updateStatus(message.getText().toString());
                } catch (TwitterException e) {
                    e.printStackTrace();
                }

                }

        });
        button = (Button) findViewById(R.id.btnSearch);

        // Capture button clicks
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(SafariCareTweetsActivity.this,
                        TweetSearchActivity.class);
                startActivity(myIntent);
            }
        });
    }
}
