package com.github.mrtuxa.commands

import net.dv8tion.jda.api.entities.emoji.Emoji
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.events.interaction.component.SelectMenuInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.interactions.components.selections.SelectMenu
import net.dv8tion.jda.api.interactions.components.selections.SelectOption

class DropdownExample : ListenerAdapter() {
    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        if (event.name == "food") {
            val selectMenu = SelectMenu.create("choose-food")
                .addOption("Pizza", "pizza", "Classic") // SelectOption with only the label, value, and description
                .addOptions(
                    SelectOption.of("Hamburger", "hamburger") // another way to create a SelectOption
                    .withDescription("Tasty") // this time with a description
                    .withEmoji(Emoji.fromUnicode("\uD83C\uDF54")) // and an emoji
                    .withDefault(true)) // while also being the default option
                .build()

            event.reply("Choose your favorite food")
                .addActionRow(selectMenu)
                .queue()
        }
    }

    override fun onSelectMenuInteraction(event: SelectMenuInteractionEvent) {
        if (event.componentId == "choose-food") {
            event.reply("You chose " + event.values[0]).queue()
        }
    }
}