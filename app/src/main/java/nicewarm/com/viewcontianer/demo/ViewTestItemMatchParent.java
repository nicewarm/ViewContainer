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
public class ViewTestItemMatchParent extends ViewContainerItem {

    public ViewTestItemMatchParent(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public ViewTestItemMatchParent(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context){
        isMatchParent = 1;
        height = DisplayUtil.dip2px(context,40);
        TextView textView = new TextView(context);
        textView.setText("MATCH PARENT");
        LinearLayout.LayoutParams params= new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        addView(textView,params);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.parseColor("#ffffff"));
    }
}
