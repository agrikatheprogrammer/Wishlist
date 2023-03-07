package com.example.wishlist

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var itemsRv: RecyclerView
    private lateinit var priceEditText: EditText
    private lateinit var urlEditText: EditText
    private lateinit var nameEditText: EditText
    private lateinit var button: Button
    lateinit var wishlistItems: MutableList<Contact>

    @SuppressLint(/* ...value = */ "MissingInflatedId", "NotifyDataSetChanged")
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        itemsRv = findViewById(R.id.listRv)

        priceEditText = findViewById(R.id.editPrice)
        urlEditText = findViewById(R.id.editUrl)
        nameEditText = findViewById(R.id.editName)

        button = findViewById(R.id.button)
        wishlistItems = ArrayList()
        val adapter = ItemsAdapter(wishlistItems)
        button.setOnClickListener {

            itemsRv.adapter = adapter
            itemsRv.layoutManager = LinearLayoutManager(this)
            val newItem = Contact(priceEditText.text.toString(), nameEditText.text.toString(), urlEditText.text.toString())
            wishlistItems.add(newItem)
            adapter.notifyDataSetChanged()
        }

    }
}
