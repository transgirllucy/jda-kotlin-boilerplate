package com.github.mrtuxa.core

import com.github.mrtuxa.events.Ready
import io.github.cdimascio.dotenv.dotenv
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import javax.security.auth.login.LoginException
import kotlin.system.exitProcess

class Main {
    fun main(args: Array<String>) {

        val jda : JDA
        val dotenv = dotenv()

        // check if TOKEN in environment is null
        if (dotenv["TOKEN"] == null) {
            exitProcess(1)
        }


        try {
            jda = JDABuilder.createDefault(dotenv["TOKEN"])
                .addEventListeners(Ready())
                .build()
        } catch (e: LoginException) {
            e.stackTrace
        }
    }
}