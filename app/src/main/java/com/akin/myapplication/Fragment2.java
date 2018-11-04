package com.akin.myapplication;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class Fragment2 extends Fragment {
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_fragment2,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.recyclerview);
        Bitmap[] bitmap = getBitmaps();
        MyAdapter adapter = new MyAdapter(this, bitmap);
        GridLayoutManager manager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new Fragment2.GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
    private Bitmap[] getBitmaps() {
        Bitmap[] getbitmap = new Bitmap[10];
        getbitmap[0] = BitmapFactory.decodeResource(getResources(), R.drawable.bluebackground);
        getbitmap[1] = BitmapFactory.decodeResource(getResources(), R.drawable.bluebackground);
        getbitmap[2] = BitmapFactory.decodeResource(getResources(), R.drawable.bluebackground);
        getbitmap[3] = BitmapFactory.decodeResource(getResources(), R.drawable.bluebackground);
        getbitmap[4] = BitmapFactory.decodeResource(getResources(), R.drawable.bluebackground);
        getbitmap[5] = BitmapFactory.decodeResource(getResources(), R.drawable.bluebackground);
        getbitmap[6] = BitmapFactory.decodeResource(getResources(), R.drawable.bluebackground);
        getbitmap[7] = BitmapFactory.decodeResource(getResources(), R.drawable.bluebackground);
        getbitmap[8] = BitmapFactory.decodeResource(getResources(), R.drawable.bluebackground);
        getbitmap[9] = BitmapFactory.decodeResource(getResources(), R.drawable.bluebackground);
        return getbitmap;
    }
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }
    }
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
