package cn.edu.togethorapp.ui.home

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
//import androidx.gridlayout.widget.GridLayout;
import android.widget.TextView
import androidx.core.view.children

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import cn.edu.togethorapp.ui.home.model.CardMatchingGame
import cn.edu.togethorapp.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() , View.OnClickListener{

    private lateinit var homeViewModel: HomeViewModel

    lateinit var game: CardMatchingGame
    val  cardButtons= mutableListOf<Button>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        for (v in gridLayout.children){
            if (v is Button){
                v.setOnClickListener (this)
                cardButtons.add(v)
            }
        }
        game = CardMatchingGame(cardButtons.count())
        updateUI()
        button_reset.setOnClickListener {
            game= CardMatchingGame(cardButtons.count())
            updateUI()
        }
    }

    fun updateUI(){
        for (button in cardButtons) {
            val index = cardButtons.indexOf(button)
            val card =game.cardAtIndex(index)
            button.isEnabled=!card.isMatched
            if (card.isChosen){
                button.text = card.toString()
                button.setBackgroundColor(Color.WHITE)
            }else{
                button.text=""
                button.setBackgroundResource(R.drawable.yuzhou)
            }
        }
        score.text= String.format("%s%d","Score",game.score)
    }

    override fun onClick(v: View?) {
        if (v is Button){
            val index =cardButtons.indexOf(v)
            game.chooseCardAtIndex(index)
            updateUI()
        }
    }

}