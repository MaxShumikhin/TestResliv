package test.bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import test.service.AppService;

public class Bot extends TelegramLongPollingBot {
    AppService appService;

    @Autowired
    public void setAppService(AppService appService) {
        this.appService = appService;
    }


    @Override
    public String getBotToken() {
        return "1059192346:AAGnlzlIr4wNPviM5f0OccKUEDMYTfSvjFE";
    }

    @Override
    public String getBotUsername() {
        return "TurFirmBot";
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            switch (message.getText()) {
                case "Минск":
                    msgSend(message, "Посетите национальную Библиотеку и Зыбицкую ;) ");
                    break;

                default:
                    msgSend(message, "К сожалению такого города нет,но мы обязательно его добавим");
                    break;
            }
        }
    }

    private void msgSend(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public static void main() {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new Bot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
