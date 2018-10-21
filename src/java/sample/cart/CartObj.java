/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.cart;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mai Linh
 */
public class CartObj {

    private String customerId;
    Map<String, Integer> items;//check trùng tự động của giỏ hàng

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public void addItemToCart(String title) {
        if (this.items == null) {//kiểm tra giở hàng có chưa
            this.items = new HashMap<String, Integer>();
        }
        int quantity = 1;
        if (this.items.containsKey(title)) {//hàng có tồn tại hay chưa
            quantity = this.items.get(title) + 1;
        }
        this.items.put(title, quantity);
    }

    public void removeItemFromCart(String title) {
        if (this.items == null) {// kiểm tra giở hàng có hay chưa
            return;
        }
        if (this.items.containsKey(title)) {
            this.items.remove(title);
            if (this.items.isEmpty()) {
                this.items = null;
            }
        }
    }
}
