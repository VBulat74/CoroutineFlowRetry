package ru.com.vbulat.coroutineflowretry

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.com.vbulat.coroutineflowretry.crypto_app.CryptoActivity
import ru.com.vbulat.coroutineflowretry.databinding.ActivityMainBinding
import ru.com.vbulat.coroutineflowretry.lessons.lesson_02.UsersActivity

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.buttonUsersActivity.setOnClickListener {
            startActivity(UsersActivity.newIntent(this))
        }
        binding.buttonCryptoActivity.setOnClickListener {
            startActivity(CryptoActivity.newIntent(this))
        }
    }
}