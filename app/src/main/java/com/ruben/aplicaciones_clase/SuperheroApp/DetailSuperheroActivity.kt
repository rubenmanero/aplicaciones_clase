package com.ruben.aplicaciones_clase.SuperheroApp

import android.os.Bundle
import android.util.TypedValue
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import coil3.load
import com.ruben.aplicaciones_clase.R
import com.ruben.aplicaciones_clase.SuperheroApp.SuperheroListActivity.Companion.EXTRA_ID
import com.ruben.aplicaciones_clase.databinding.ActivityDetailSuperheroBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.roundToInt

class DetailSuperheroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailSuperheroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailSuperheroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val id: String = intent.getStringExtra(EXTRA_ID).orEmpty()
        getSuperheroInformation(id)
    }

    private fun getSuperheroInformation(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val superheroDetail: Response<SuperheroDetailResponse> = getRetrofit().
            create(ApiService::class.java).
            getSuperheroDetail(id)

            if(superheroDetail.body() != null) {
                runOnUiThread {
                    createUI(superheroDetail.body()!!)
                }
            }
        }
    }

    private fun createUI(superhero: SuperheroDetailResponse) {
        binding.ivSuperhero.load(superhero.image.url)

        binding.tvSuperheroName.text = superhero.name
        binding.tvSuperheroRealName.text = superhero.biography.fullName
        binding.tvSuperheroName.text = superhero.biography.publisher

        prepareStats(superhero.powerstats)
    }

    private fun prepareStats(powerstats: PowerStatsResponse) {
        updateHeight(binding.viewIntelligence, powerstats.intelligence)
        updateHeight(binding.viewStrength, powerstats.strength)
        updateHeight(binding.viewSpeed, powerstats.speed)
        updateHeight(binding.viewDurability, powerstats.durability)
        updateHeight(binding.viewPower, powerstats.power)
        updateHeight(binding.viewCombat, powerstats.combat)
    }

    private fun updateHeight(view: View, stat: String) {
        val params = view.layoutParams
        params.height = pxToDp(stat.toFloat())
        view.layoutParams = params
    }

    private fun pxToDp(px:Float):Int{
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, resources.displayMetrics).roundToInt()
    }



    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/api/10229233666327556/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}