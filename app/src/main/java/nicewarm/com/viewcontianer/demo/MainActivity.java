package nicewarm.com.viewcontianer.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import nicewarm.com.viewcontianer.R;
import nicewarm.com.viewcontianer.lib.ViewContainer;

public class MainActivity extends AppCompatActivity {

    private LinearLayout rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rootView = (LinearLayout) findViewById(R.id.rootView);
        initView();
    }


    private void initView() {
        /*第一组view*/
        TextView textViewOne = new TextView(MainActivity.this);
        textViewOne.setText("第一组view");
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,100);
        textViewOne.setLayoutParams(params);
        textViewOne.setGravity(Gravity.CENTER);
        textViewOne.setTextColor(Color.parseColor("#FFFFFF"));
        textViewOne.setBackgroundColor(Color.parseColor("#0096db"));
        rootView.addView(textViewOne);
        ViewContainer viewContainerOne = new ViewContainer(MainActivity.this);
        viewContainerOne.columns = 5;
        viewContainerOne.hasDivider = 1;
        viewContainerOne.dividerWid = 5;
        viewContainerOne.dividerColor = Color.parseColor("#ffffff");
        ViewTestItemMatchParent matchParent = new ViewTestItemMatchParent(MainActivity.this);
        matchParent.setBackgroundColor(randomColor());
        viewContainerOne.addView(matchParent);
        for (int i = 0; i < 18; i++) {
            ViewTestIteWidEqualHei widEqualHei = new ViewTestIteWidEqualHei(MainActivity.this);
            widEqualHei.setBackgroundColor(randomColor());
            viewContainerOne.addView(widEqualHei);
        }
        rootView.addView(viewContainerOne);



        /*第二组view*/
        TextView textViewTwo = new TextView(MainActivity.this);
        textViewTwo.setText("第二组view");
        LinearLayout.LayoutParams paramsTwo = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,100);
        textViewTwo.setLayoutParams(paramsTwo);
        textViewTwo.setGravity(Gravity.CENTER);
        textViewTwo.setTextColor(Color.parseColor("#FFFFFF"));
        textViewTwo.setBackgroundColor(Color.parseColor("#0096db"));
        rootView.addView(textViewTwo);
        ViewContainer viewContainerTwo = new ViewContainer(MainActivity.this);
        viewContainerTwo.columns = 3;
        viewContainerTwo.hasDivider = 1;
        viewContainerTwo.dividerWid = 5;
        viewContainerTwo.dividerColor = Color.parseColor("#ffffff");
        for (int i = 0; i < 7; i++) {
            ViewTestIteOnlyHei notMactchParent = new ViewTestIteOnlyHei(MainActivity.this);
            notMactchParent.setBackgroundColor(randomColor());
            viewContainerTwo.addView(notMactchParent);
        }
        ViewTestItemMatchParent matchParentTwo = new ViewTestItemMatchParent(MainActivity.this);
        matchParentTwo.setBackgroundColor(randomColor());
        viewContainerTwo.addView(matchParentTwo);
        rootView.addView(viewContainerTwo);



        /*第三组view*/
        TextView textViewThree = new TextView(MainActivity.this);
        textViewThree.setText("第三组view");
        LinearLayout.LayoutParams paramsThree = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,100);
        textViewThree.setLayoutParams(paramsThree);
        textViewThree.setGravity(Gravity.CENTER);
        textViewThree.setTextColor(Color.parseColor("#FFFFFF"));
        textViewThree.setBackgroundColor(Color.parseColor("#0096db"));
        rootView.addView(textViewThree);
        ViewContainer viewContainerThree = new ViewContainer(MainActivity.this);
        viewContainerThree.columns = 3;
        viewContainerThree.hasDivider = 1;
        viewContainerThree.dividerWid = 5;
        viewContainerThree.dividerColor = Color.parseColor("#ffffff");
        for (int i = 0; i < 7; i++) {
            ViewTestIteWidEqualHei widEqualHei = new ViewTestIteWidEqualHei(MainActivity.this);
            widEqualHei.setBackgroundColor(randomColor());
            viewContainerThree.addView(widEqualHei);
        }
        ViewTestItemMatchParent matchParentThree = new ViewTestItemMatchParent(MainActivity.this);
        matchParentThree.setBackgroundColor(randomColor());
        viewContainerThree.addView(matchParentThree);
        rootView.addView(viewContainerThree);





    }

    private int randomColor() {
        int colorValue = (int) (Math.random() * (16777216 - 1) + 1)*-1;
        String hex = Integer.toHexString(colorValue);
        return Color.parseColor("#" + hex);
    }


}
