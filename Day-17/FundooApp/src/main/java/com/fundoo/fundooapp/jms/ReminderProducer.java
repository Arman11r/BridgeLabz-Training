package com.fundoo.fundooapp.jms;

import com.fundoo.fundooapp.dto.ReminderMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReminderProducer {

    public static final String REMINDER_QUEUE = "reminder-queue";

    private final JmsTemplate jmsTemplate;

    public void sendReminder(ReminderMessage message) {
        jmsTemplate.convertAndSend(REMINDER_QUEUE, message);
    }
}