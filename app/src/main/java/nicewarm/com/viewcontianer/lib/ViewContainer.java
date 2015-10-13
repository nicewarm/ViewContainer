package nicewarm.com.viewcontianer.lib;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * Created by sreay on 15/8/21.
 */
public class ViewContainer extends ViewGroup {
    /*一共几列*/
    public int columns = 2;
    /*是否有分割线，0为没有，1为有分割线，分割线只是子View连接之间的分割线，上下左右边线用padding就好*/
    public int hasDivider = 0;
    /*分割线的宽度*/
    public int dividerWid = 0;
    /*分割线的颜色*/
    public int dividerColor = Color.parseColor("#666666");

    public ViewContainer(Context context) {
        super(context);
    }

    public ViewContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        /*屏幕总宽度*/
        int match_parent_wid_value = MeasureSpec.getSize(widthMeasureSpec);
        /*需要的总高度*/
        int total_hei = 0;
        /*当前的宽度*/
        int tempWid = 0;
        /*上一个子View的高度*/
        int beforeHeight = 0;
        /*子View的宽度值*/
        int childWidthValue = 0;
        /*子View的高度值*/
        int childHeiValue = 0;
        /*子View的高度MeasureSpec值*/
        int childHeight = 0;
        /*子View的宽度MeasureSpec值*/
        int childWidth = 0;
        /**计算一共有多少行**/
        int rowCount = 0;
        /*分割线的宽度*/
        int divider= 0;

        if (hasDivider == 0){
            divider = 0;
        }else if (hasDivider == 1){
            divider = dividerWid;
        }
        for (int i = 0; i < getChildCount(); i++) {
            ViewContainerItem view = (ViewContainerItem) getChildAt(i);
            if (view.isMatchParent == 1) {
                childWidthValue = match_parent_wid_value;
            } else {
                /**每个子View的真正的宽度,减去分割线的宽度**/
                childWidthValue = (match_parent_wid_value - (columns - 1) * divider) / columns;
            }
            /*高度是否跟宽度相等，正方形*/
            if (view.isHeiEqualWid == 1) {
                childHeiValue = childWidthValue;
            } else {
                /**如果没有指定宽度和高度相等，那么检查有没有设置radio，宽高比例**/
                if (Math.abs(view.radio - 1.0f) != 0) {
                    childHeiValue = (int) (childWidthValue / view.radio);
                } else {
                    /*什么都没有设置的view，高度等于自身设置的高度*/
                    childHeiValue = view.height;
                }
            }
            /*为每一个子View的宽高计算MeasureSpec值*/
            childWidth = MeasureSpec.makeMeasureSpec(childWidthValue, MeasureSpec.EXACTLY);
            childHeight = MeasureSpec.makeMeasureSpec(childHeiValue, MeasureSpec.EXACTLY);
            /**换行**/
            if (tempWid + childWidthValue > match_parent_wid_value) {
                total_hei += beforeHeight;
                rowCount++;
                tempWid = 0;
            }
            if (view.isMatchParent == 1) {
                view.measure(widthMeasureSpec, childHeight);
                tempWid += match_parent_wid_value;
            } else {
                view.measure(childWidth, childHeight);
                tempWid += childWidthValue;
            }
            beforeHeight = childHeight;
            if (i == getChildCount() - 1) {
                total_hei += beforeHeight;
                rowCount++;
            }
        }
        /**计算完毕后，加上divider的高度**/
        /** 有底部分割线时，分割线的数目等于行数，没有底部分割线时，分割线的数目等于行数减一 **/
        int dividerCount = 0;
        dividerCount = rowCount - 1;
        /*总高度加上分割线的高度*/
        total_hei += dividerCount * divider;
        int totalHei = MeasureSpec.makeMeasureSpec(total_hei, MeasureSpec.EXACTLY);
        /*设置背景色，分割线其实就是背景色透过来的颜色，在onlayout时，每个子View之间有间隙，透过来的缝隙就是分割线*/
        setBackgroundColor(dividerColor);
        setMeasuredDimension(widthMeasureSpec, totalHei);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int tempWidth = 0;
        int tempHeight = 0;
        int beforeHeight = 0;
        int divider = 0;
        /*分割线*/
        if (hasDivider == 1) {
            divider = dividerWid;
        } else if (hasDivider == 0){
            divider = 0;
        }
        for (int i = 0; i < getChildCount(); i++) {
            ViewContainerItem view = (ViewContainerItem) getChildAt(i);
            int width = view.getMeasuredWidth();
            int height = view.getMeasuredHeight();
            /*如果已经超过了屏幕宽度，则换行*/
            if (tempWidth + width > r) {
                /*换行时，加上上一行的高度，还要加上分割线的高度*/
                tempHeight += beforeHeight+divider;
                /*宽度置为0，从最左边开始布局子view*/
                tempWidth = 0;
            }
            /*占满屏幕宽度的子View*/
            if (view.isMatchParent == 1) {
                view.layout(tempWidth, tempHeight, r, tempHeight + height);
                tempWidth += r;
            } else {
                /*普通子View*/
                view.layout(tempWidth, tempHeight, tempWidth + width, tempHeight + height);
                /*布局完前一个子View，加上前一个View的宽度后，还要加上分割线的宽度
                * 下一次布局时，就留出来了分割线的宽度
                * 因为算的是布局时起始的位置，所以即使是一行中最后一个View也不会因为多加了分割线出问题
                * */
                tempWidth += width + divider;
            }
            /*记录上一个View的高度，如果下一个View在当前行排不开了，需要另起一行，需要加上前一行的高度*/
            beforeHeight = height;
        }
    }
}
