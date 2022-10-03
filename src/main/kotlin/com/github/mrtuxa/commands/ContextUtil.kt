package com.github.mrtuxa.commands

import net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent
import net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class ContextUtil : ListenerAdapter() {
    override fun onUserContextInteraction(event: UserContextInteractionEvent) {
        if (event.name == "Get user avatar") {
            event.reply("Avatar: ${event.target.effectiveAvatarUrl}").setEphemeral(true).queue()
        }
    }

    override fun onMessageContextInteraction(event: MessageContextInteractionEvent) {
        if (event.name == "Count words") {
            event.reply("Words: ${event.target.contentRaw.split(Regex("\\s+")).size}").setEphemeral(true).queue()
        }
    }
}