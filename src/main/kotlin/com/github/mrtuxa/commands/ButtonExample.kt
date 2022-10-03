package com.github.mrtuxa.commands

import net.dv8tion.jda.api.entities.emoji.Emoji
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.interactions.components.ActionRow
import net.dv8tion.jda.api.interactions.components.buttons.Button

class ButtonExample : ListenerAdapter() {
    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        if (event.name == "hello") {
            event.reply("Click button to say hello")
                .addComponents(
                    ActionRow.of(
                        Button.primary("hello", "Click me"), // Button with only a label
                        Button.success("emoji", Emoji.fromFormatted("<:minn:245267426227388416>")) // Button with only an emoji
                    )
                ).queue()
        }
    }

    override fun onButtonInteraction(event: ButtonInteractionEvent) {
        when(event.componentId) {
            "hello" -> {
                event.reply("Hello :)").setEphemeral(true).queue()
            }
            "emoji" -> {
                event.editMessage("That button didn't said click me").queue()
            }
        }
    }
}