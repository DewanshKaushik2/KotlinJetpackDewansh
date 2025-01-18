package com.example.a20180101_dewanshkaushik_nycschools.stripe

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.stripe.android.PaymentConfiguration

class StripeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize with your Publishable Key
        PaymentConfiguration.init(getApplicationContext(),"your_publishable_key");


    }









}