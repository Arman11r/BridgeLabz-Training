package com.fundoo.fundooapp.jms;

import com.fundoo.fundooapp.dto.ReminderMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReminderConsumer {

    @JmsListener(destination = ReminderProducer.REMINDER_QUEUE)
    public void handleReminder(ReminderMessage message) {
        // simulated processing -- UC22 replaces this with real email delivery
        log.info("Processing reminder for noteId={} user={} at={}",
                message.getNoteId(), message.getUserEmail(), message.getReminderTime());

        try {
            Thread.sleep(3000); // simulated slow work, proves the async decoupling
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        log.info("Reminder processed for noteId={}", message.getNoteId());
    }
}