package jamme.dev.real.time.transactions.real_time_transactions.service;

import jamme.dev.real.time.transactions.real_time_transactions.constants.Messages;
import jamme.dev.real.time.transactions.real_time_transactions.model.Alert;
import jamme.dev.real.time.transactions.real_time_transactions.model.Transaction;
import jamme.dev.real.time.transactions.real_time_transactions.repository.AlertRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AlertService {

    private final AlertRepo alertRepo;

    public AlertService(AlertRepo alertRepo) {
        this.alertRepo = alertRepo;
    }

    public void checkForAlert(Transaction transaction) {

        boolean isSus = false;
        String reason = "";

        //Rule 1 for sus activities
        if (transaction.getAmount() > 1_000_000){
            isSus = true;
            reason = Messages.Sus.TRANSACTION_AMOUNT;
        }

        if (isSus) saveAlert(transaction, reason);

    }

    private void saveAlert(Transaction transaction, String reason) {
        Alert alert = new Alert();
        alert.setTransactionId(transaction.getTransactionId());
        alert.setAmount(transaction.getAmount());
        alert.setAlertReason(reason);
        alert.setLocalDateTime(LocalDateTime.now());

        alertRepo.save(alert);
    }
}
