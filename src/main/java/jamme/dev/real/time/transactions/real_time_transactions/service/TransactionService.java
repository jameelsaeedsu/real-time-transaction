package jamme.dev.real.time.transactions.real_time_transactions.service;

import jamme.dev.real.time.transactions.real_time_transactions.model.Transaction;

public interface TransactionService {

    void processTransaction(Transaction transaction);

}
