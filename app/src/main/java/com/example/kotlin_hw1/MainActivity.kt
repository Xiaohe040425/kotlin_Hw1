package com.example.kotlin_hw1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var ed_name: EditText
    private lateinit var tv_text: TextView
    private lateinit var tv_name: TextView
    private lateinit var tv_winner: TextView
    private lateinit var tv_mmora: TextView
    private lateinit var tv_cmora: TextView
    private lateinit var btn_scissor: RadioButton
    private lateinit var btn_stone: RadioButton
    private lateinit var btn_paper: RadioButton
    private lateinit var btn_mora: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // 連結 layout

        // 綁定 XML 的元件
        ed_name = findViewById(R.id.ed_name)
        tv_text = findViewById(R.id.tv_text)
        tv_name = findViewById(R.id.tv_name)
        tv_winner = findViewById(R.id.tv_winner)
        tv_mmora = findViewById(R.id.tv_mmora)
        tv_cmora = findViewById(R.id.tv_cmora)
        btn_scissor = findViewById(R.id.btn_scissor)
        btn_stone = findViewById(R.id.btn_stone)
        btn_paper = findViewById(R.id.btn_paper)
        btn_mora = findViewById(R.id.btn_mora)

        // 設置按鈕點擊監聽器
        btn_mora.setOnClickListener {
            val playerName = ed_name.text.toString()
            if (playerName.isEmpty()) {
                tv_text.text = "請輸入玩家姓名"
                return@setOnClickListener
            }

            // 顯示玩家姓名
            tv_name.text = "名字\n$playerName"

            // 獲取玩家選擇
            val playerChoice = when {
                btn_scissor.isChecked -> "剪刀"
                btn_stone.isChecked -> "石頭"
                btn_paper.isChecked -> "布"
                else -> "未知"
            }
            tv_mmora.text = "我方出拳\n$playerChoice"

            // 隨機生成電腦選擇
            val computerChoice = (0..2).random()
            val computerMove = when (computerChoice) {
                0 -> "剪刀"
                1 -> "石頭"
                else -> "布"
            }
            tv_cmora.text = "電腦出拳\n$computerMove"

            // 判斷勝負
            val result = when {
                (playerChoice == "剪刀" && computerMove == "布") ||
                        (playerChoice == "石頭" && computerMove == "剪刀") ||
                        (playerChoice == "布" && computerMove == "石頭") -> {
                    "勝利者\n$playerName"
                }
                (playerChoice == computerMove) -> {
                    "勝利者\n平手"
                }
                else -> {
                    "勝利者\n電腦"
                }
            }
            tv_winner.text = result
            tv_text.text = when (result) {
                "勝利者\n$playerName" -> "恭喜您獲勝了！！！"
                "勝利者\n電腦" -> "可惜，電腦獲勝了！"
                else -> "平局，請再試一次！"
            }
        }
    }
}