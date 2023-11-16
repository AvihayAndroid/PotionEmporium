package com.example.potionemporium;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FBRef {
    public static FirebaseDatabase FBDB = FirebaseDatabase.getInstance();

    public static DatabaseReference refUser = FBDB.getReference("User");
    public static DatabaseReference refIngredients = FBDB.getReference("Ingredients");
    public static DatabaseReference refPotions = FBDB.getReference("Potions");
}