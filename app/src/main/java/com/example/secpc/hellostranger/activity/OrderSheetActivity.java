package com.example.secpc.hellostranger.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

import com.example.secpc.hellostranger.R;

public class OrderSheetActivity extends AppCompatActivity {

    final int ORDER_SIZE = 2; // 영상용으로 보여주기 위함. 임의로 제한.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_sheet);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.order_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        List<Dumy_Order> orders = new ArrayList<>();
        Dumy_Order[] order = new Dumy_Order[ORDER_SIZE];
        order[0] = new Dumy_Order(R.drawable.order_bulgogi_image, "불고기(Bulgogi)", "1", "₩ 10,800  ");
        order[1] = new Dumy_Order(R.drawable.order_kimchijji_image, "김치찌개(Kimchijji)", "1", "₩ 7,000  ");

        for(int i = 0; i < ORDER_SIZE; i++) {
            orders.add(order[i]);
        }

        recyclerView.setAdapter(new OrderAdapter(getApplicationContext(), orders, R.layout.activity_order_sheet));
    }
}
