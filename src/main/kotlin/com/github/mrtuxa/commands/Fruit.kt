package com.github.mrtuxa.commands

import net.dv8tion.jda.api.events.interaction.command.CommandAutoCompleteInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

private val words = arrayOf("apple", "apricot", "banana", "cherry", "coconut", "cranberry")

class Fruit : ListenerAdapter() {
    override fun onCommandAutoCompleteInteraction(event: CommandAutoCompleteInteractionEvent) {
        if (event.name == "fruit" && event.focusedOption.name == "name") {
            event.replyChoiceStrings(words.filter {
                it.startsWith(event.focusedOption.value)
            }).queue()
        }
    }
}