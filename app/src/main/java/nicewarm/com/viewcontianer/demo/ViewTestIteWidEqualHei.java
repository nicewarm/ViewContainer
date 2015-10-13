package nicewarm.com.viewcontianer.demo;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import nicewarm.com.viewcontianer.DisplayUtil;
import nicewarm.com.viewcontianer.lib.ViewContainerItem;

/**
 * Created by sreay on 15/10/13.
 */
public class ViewTestIteWidEqualHei extends ViewContainerItem {


    public ViewTestIteWidEqualHei(Context context) {
        super(context);
        initView(context);
    }

    public ViewTestIteWidEqualHei(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context){
        isHeiEqualWid = 1;
        TextView textView = new TextView(context);
        textView.setText("正方形");
        LinearLayout.LayoutParams params= new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        addView(textView,params);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.parseColor("#ffffff"));
    }
}
