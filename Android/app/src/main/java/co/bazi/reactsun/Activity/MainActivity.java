package co.bazi.reactsun.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.util.List;

import co.bazi.reactsun.APIHelper.FeedProvider;
import co.bazi.reactsun.Model.FeedItem;
import co.bazi.reactsun.R;

public class MainActivity extends AppCompatActivity implements FeedProvider.APIFeedFetcherCallback{

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.feedtext);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }

    @Override
    protected void onStart() {
        super.onStart();
        FeedProvider.getFeedFromServer(this);


    }

    @Override
    public void OnFeedFetched(List<FeedItem> feedItemList) {
        List<FeedItem> list = feedItemList;
        String feeds = "";
        for (FeedItem feedItem : list){
            feeds = feeds+feedItem.toString();
        }
        textView.setText(feeds);
    }
}
