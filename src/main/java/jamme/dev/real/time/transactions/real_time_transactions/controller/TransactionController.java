package jamme.dev.real.time.transactions.real_time_transactions.controller;


import jamme.dev.real.time.transactions.real_time_transactions.model.Transaction;
import jamme.dev.real.time.transactions.real_time_transactions.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerTransaction(
            @RequestBody Transaction transaction) {
        transactionService.processTransaction(transaction);
        return ResponseEntity.ok("Transaction received");
    }
}
