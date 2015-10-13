package nicewarm.com.viewcontianer.lib;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by sreay on 15/8/21.
 */
public abstract class ViewContainerItem extends LinearLayout{

    public int isMatchParent = 0;
    public int height = 0;
    public int isHeiEqualWid = 0;
    /**孩子的宽高比例，不一定是正方形,width/height**/
    public float radio = 1.0f;
    public int isFooter = 0;

    public ViewContainerItem(Context context) {
        super(context);
    }

    public ViewContainerItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
}
