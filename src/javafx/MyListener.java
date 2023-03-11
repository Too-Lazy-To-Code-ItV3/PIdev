
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;

import models.Produits;

/**
 *
 * @author aouad
 */
public interface MyListener {
    public void onClickListener(Produits prod);
    public Produits getProduit();
}
