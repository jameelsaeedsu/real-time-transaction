package jamme.dev.real.time.transactions.real_time_transactions.repository;

import jamme.dev.real.time.transactions.real_time_transactions.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {

    List<Transaction> findByAccountNumber(String accountNumber);

}
