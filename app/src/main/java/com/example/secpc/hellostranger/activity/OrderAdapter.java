package com.example.secpc.hellostranger.activity;

import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import android.widget.Toast;
import com.example.secpc.hellostranger.R;

/**
 * Created by jubee on 16. 10. 24.
 */
public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {
    Context context;
    List<Dumy_Order> items; // Dumy_Order는 후에 `/data/Order`로 변경한다.
    int item_layout;

    public OrderAdapter(Context context, List<Dumy_Order> items, int item_layout) {
        this.context = context;
        this.items = items;
        this.item_layout = item_layout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //recycler view에 반복될 아이템 레이아웃을 연결한다
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.orderd_item, null);
        return new ViewHolder(v);
    }

    /** 정보 및 이벤트 처리는 이 메소드에서 구현 **/
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        /*
        * Dumy_Order는 `/data/Order`로 추후에 변경
        * */
        final Dumy_Order item = items.get(position);
        Drawable drawable = ContextCompat.getDrawable(context, item.getMenu_picture());
        holder.menu_picture.setImageDrawable(drawable);
        holder.menu_name.setText(item.getMenu_name());
        holder.menu_qauntity.setText(item.getMenu_qauntity());
        holder.menu_price.setText(item.getMenu_price());

        /*
        * 메뉴 아이템 클릭. - 테스트용
        * */
        holder.oder_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, item.getMenu_name() + " " + item.getMenu_qauntity() + "개 주문", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    /** item layout 불러오기 **/
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView menu_qauntity; // 메뉴 수량
        TextView menu_name;     // 메뉴 이름
        TextView menu_price;    // 메뉴 가격
        ImageView menu_picture; // 메뉴 사진
        CardView oder_cv;       // 카드뷰

        public ViewHolder(View itemView) {
            super(itemView);
            menu_qauntity = (TextView) itemView.findViewById(R.id.menu_qauntity);   // 메뉴 수량
            menu_name = (TextView) itemView.findViewById(R.id.menu_name);           // 메뉴 이름
            menu_price = (TextView) itemView.findViewById(R.id.menu_price);         // 메뉴 가격
            menu_picture = (ImageView) itemView.findViewById(R.id.menu_picture);    // 메뉴 사진
            oder_cv = (CardView) itemView.findViewById(R.id.oder_cv);               // 카드뷰
        }
    }
}
