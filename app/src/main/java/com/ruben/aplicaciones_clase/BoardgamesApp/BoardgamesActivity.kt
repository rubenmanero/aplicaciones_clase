package com.ruben.aplicaciones_clase.BoardgamesApp

import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.ruben.aplicaciones_clase.BoardgamesApp.GameCategory.*
import com.ruben.aplicaciones_clase.R

class BoardgamesActivity : AppCompatActivity() {
    private val categories = listOf(Cooperative, Deckbuilding, Euro, LCG, Legacy)

    private val games = mutableListOf (
        Game("Frostpunk", Cooperative),
        Game("Hero Realm", Deckbuilding),
        Game("Agricola", Euro),
        Game("Arkham Horror", LCG),
        Game("Gloomhaven", Legacy),
        Game("Arkham Horror", LCG),
        Game("Clank! Legacy", Legacy),
        Game("Marvel Champions", LCG),
        Game("Pandemic Legacy", Legacy)
    )

    private lateinit var rvCategories: RecyclerView
    private lateinit var rvGames: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var gamesAdapter: GamesAdapter
    private lateinit var fabAddGame: FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_boardgames)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponents()
        initListeners()
        initUI()
    }

    private fun initListeners() {
        fabAddGame.setOnClickListener { showDialog() }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_game)

        val btnAddGame: CardView = dialog.findViewById(R.id.btnAddGame)
        val etGame: EditText = dialog.findViewById(R.id.etGame)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnAddGame.setOnClickListener {
            val currentGame = etGame.text.toString()
            if(currentGame.isNotEmpty()){
                val selectedId = rgCategories.checkedRadioButtonId
                val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedId)

                val currentCategory: GameCategory = when(selectedRadioButton.text) {
                    getString(R.string.bgapp_cooperative_category) -> Cooperative
                    getString(R.string.bgapp_deckbuilding_category) -> Deckbuilding
                    getString(R.string.bgapp_lcg_category) -> LCG
                    getString(R.string.bgapp_euro_category) -> Euro
                    else -> Legacy
                }
                games.add(Game(currentGame,currentCategory))
                updateGames()
                dialog.hide()
            }
        }

        dialog.show()
    }

    private fun updateGames() {
        val selectedCategories: List<GameCategory> = categories.filter { category ->
            category.isSelected
        }
        val newGames: List<Game> = games.filter { selectedCategories.contains(it.category)}
        gamesAdapter.games = newGames

        gamesAdapter.notifyDataSetChanged()
    }

    private fun onGameSelected(position: Int) {
        gamesAdapter.games[position].isSelected = !gamesAdapter.games[position].isSelected
        updateGames()
    }

    private fun onCategorySelected(position: Int) {
        categories[position].isSelected = !categories[position].isSelected
        categoriesAdapter.notifyItemChanged(position)
        updateGames()
    }

    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories) { position -> onCategorySelected(position) }
        rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter

        gamesAdapter = GamesAdapter(games) { position -> onGameSelected(position) }
        rvGames.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvGames.adapter = gamesAdapter
    }

    private fun initComponents() {
        rvCategories = findViewById(R.id.rvCategories)
        rvGames = findViewById(R.id.rvGames)
        fabAddGame = findViewById(R.id.fabAddGame)
    }
}