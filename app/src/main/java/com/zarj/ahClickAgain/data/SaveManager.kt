package com.zarj.ahClickAgain.data

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.zarj.ahClickAgain.Player
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

object SaveManager {
    private const val PREFS_NAME = "SHKOTEL"
    private const val AUTO_SAVE_INTERVAL = 5000L

    private lateinit var prefs: SharedPreferences
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    @Volatile private var dirty = false
    @Volatile private var lastSaveTime = 0L

    fun init(context: Context) {
        prefs = context.applicationContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun markDirty() { dirty = true }

    /** Вызывать из фонового цикла раз в ~секунду */
    fun autoSaveIfNeeded() {
        if (!dirty) return
        if (System.currentTimeMillis() - lastSaveTime < AUTO_SAVE_INTERVAL) return

        dirty = false
        lastSaveTime = System.currentTimeMillis()
        scope.launch { persist(useCommit = false) }
    }

    /** Критичные события: покупка, босс, перерождение. Без дебаунса. */
    fun saveImmediate() {
        dirty = false
        lastSaveTime = System.currentTimeMillis()
        scope.launch { persist(useCommit = true) }
    }

    /** Lifecycle: onStop — самый надёжный момент */
    fun saveBlocking() {
        dirty = false
        lastSaveTime = System.currentTimeMillis()
        persist(useCommit = true) // синхронно, но onStop не блокирует UI так критично
    }

    private fun persist(useCommit: Boolean) {
        val e = prefs.edit()
        e.putLong("coins", Player.coins)
        e.putLong("diamonds", Player.diamond)
        e.putLong("damage", Player.damage)
        e.putInt("rebirth", Player.rebirthes)
        e.putLong("reb_coins", Player.reb_coins)
        e.putLong("dps", Player.dps)
        e.putString("level", Player.on_level.getFullId())
        e.putInt("exp", Player.on_level.getExp())
        e.putString("weapon", Player.weapon.getId())
        if (useCommit) {
            val ok = e.commit()
            if (!ok) Log.e("SaveManager", "commit failed")
        } else {
            e.apply()
        }
    }

    fun load(context: Context) {
        init(context)
        // делегируем в старую полную загрузку, пока Player не разобран
        Player.loadFromSharedPer(prefs)
    }
}