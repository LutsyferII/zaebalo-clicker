package com.zarj.ahClickAgain

import androidx.compose.runtime.mutableStateOf
import java.util.Timer
import java.util.TimerTask

class ZTimer {
    var timer = Timer()
    var main_task :TimerTask = object: TimerTask(){
        override fun run() {
            onTick()
            toOnTick()
        }
    }

    var tick = mutableStateOf(0L)
    val end_tick = mutableStateOf(30000L)
    lateinit var onTick : TimerTask.()  -> Unit
    lateinit var onEnd : TimerTask.()  -> Unit
    val toOnTick : TimerTask.() -> Unit = {

        tick.value+=1000L
        if(tick.value>=end_tick.value){
            System.out.println("ENDD + ${tick.value} = ${end_tick.value}")
            onEnd()
            tick.value = 0L
            cancel()
        }}

    constructor(end:Long, onTick : TimerTask.()  -> Unit, onEnd : TimerTask.()  -> Unit){
        this.end_tick.value = end
        this.onTick =onTick
        this.onEnd = onEnd

    }

    public fun chengeEndTick(ticks : Long){
        this.end_tick.value = ticks
    }

    public fun start(){
        timer = Timer()
        val task: TimerTask = object: TimerTask(){
            override fun run() {
                onTick()
                toOnTick()
            }
        }
        timer.schedule(task,1000L,1000L);

    }
    public fun stop(){
        main_task.cancel()
        timer.cancel()
    }


}