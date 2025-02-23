package com.example.cartsection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    private List<Product> cartItems;
    private Context context;

    public CartAdapter(List<Product> cartItems) {
        this.cartItems = cartItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = cartItems.get(position);
        holder.productName.setText(product.getName());
        holder.tvQuantity.setText(String.valueOf(product.getQuantity()));

        // Handle Radio Button Selection Toggle
        holder.radioButton.setOnClickListener(v -> {
            if (holder.radioButton.isChecked()) {
                product.setSelected(!product.isSelected());  // Toggle selection
                holder.radioButton.setChecked(product.isSelected()); // Update UI
            } else {
                product.setSelected(false);
                holder.radioButton.setChecked(false);
            }
        });

        // Keep UI updated on scroll
        holder.radioButton.setChecked(product.isSelected());

        // Handle Minus Button Click
        holder.btnMinus.setOnClickListener(v -> {
            if (product.getQuantity() > 1) {
                product.setQuantity(product.getQuantity() - 1);
                notifyItemChanged(position);
            } else {
                cartItems.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, cartItems.size());
            }
        });

        // Handle Plus Button Click
        holder.btnPlus.setOnClickListener(v -> {
            product.setQuantity(product.getQuantity() + 1);
            notifyItemChanged(position);
        });
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView productName, tvQuantity;
        Button btnMinus, btnPlus;
        RadioButton radioButton;  // Add this line ✅

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.productName);
            tvQuantity = itemView.findViewById(R.id.tvQuantity);
            btnMinus = itemView.findViewById(R.id.btnMinus);
            btnPlus = itemView.findViewById(R.id.btnPlus);
            radioButton = itemView.findViewById(R.id.radioButton);  // Initialize it ✅
        }
    }
}
