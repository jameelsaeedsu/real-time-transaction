package jamme.dev.real.time.transactions.real_time_transactions.service.impl;

import jamme.dev.real.time.transactions.real_time_transactions.model.Transaction;
import jamme.dev.real.time.transactions.real_time_transactions.repository.TransactionRepo;
import jamme.dev.real.time.transactions.real_time_transactions.service.AlertService;
import jamme.dev.real.time.transactions.real_time_transactions.service.TransactionService;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepo transactionRepo;
    private final AlertService alertService;

    public TransactionServiceImpl(TransactionRepo transactionRepo,
                                  AlertService alertService) {
        this.transactionRepo = transactionRepo;
        this.alertService = alertService;
    }

    @Override
    public void processTransaction(Transaction transaction) {
        transactionRepo.save(transaction);
        alertService.checkForAlert(transaction);
    }

}
