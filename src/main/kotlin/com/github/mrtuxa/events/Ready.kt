package com.github.mrtuxa.events

import com.github.mrtuxa.commands.ContextUtil
import com.github.mrtuxa.commands.DropdownExample
import com.github.mrtuxa.commands.Fruit
import com.github.mrtuxa.commands.ModalExample
import com.github.mrtuxa.core.Main
import io.github.cdimascio.dotenv.dotenv
import net.dv8tion.jda.api.entities.Guild
import net.dv8tion.jda.api.events.ReadyEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.interactions.commands.Command
import net.dv8tion.jda.api.interactions.commands.OptionType
import net.dv8tion.jda.api.interactions.commands.build.Commands
import net.dv8tion.jda.api.interactions.commands.build.OptionData

class Ready : ListenerAdapter() {
    override fun onReady(event: ReadyEvent) {
        val dotenv = dotenv()
        println(event.jda.selfUser.name)
        val guild : Guild = dotenv["GUILD"] as Guild
        guild.updateCommands().addCommands(
            Commands.slash("fruit", "find a given fruit")
                .addOption(OptionType.STRING, "name", "fruit to find"),
            Commands.context(Command.Type.USER, "Get user avatar"),
            Commands.message("Count words"),
            Commands.slash("hello", "Replies with Buttons"),
            Commands.slash("info", "Get more informations about jda and the boilerplate"),
            Commands.slash("dropdown", "Dropdown menu example"),
            Commands.slash("modal", "Modal Example")
        ).queue()

        event.jda.addEventListener(Fruit())
        event.jda.addEventListener(ContextUtil())
        event.jda.addEventListener(DropdownExample())
        event.jda.addEventListener(ModalExample())
    }
}