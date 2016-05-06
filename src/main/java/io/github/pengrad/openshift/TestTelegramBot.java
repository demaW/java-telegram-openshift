package io.github.pengrad.openshift;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;

/**
 * stas
 * 12/10/15.
 */
public class TestTelegramBot extends BotHandler {

    public static final String BOT_TOKEN = "187503040:AAEJzEJHJ0t517weDXY7bttDatnrwFZpPM8";
    TelegramBot bot = TelegramBotAdapter.buildDebug(BOT_TOKEN);

    @Override
    protected boolean onStart(Message message) {
        Long chatId = message.chat().id();
        bot.sendMessage(chatId, "Welcome!");
        return true;
    }

    @Override
    void onWebhookUpdate(Update update) {
        Message message = update.message();
        bot.sendMessage(message.chat().id(), "Ok, I hear you!");
    }
}
