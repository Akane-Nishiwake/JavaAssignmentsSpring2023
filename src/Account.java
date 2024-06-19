public class Account {
        private int id;
        private double balance;
        public Account(int id, double balance)
        {
            this.id = id; //initializes  id
            this.balance = balance;//initializes balance
        }
        public double getBalance()
        {
            return balance;//returns current balance
        }
        public void withdraw(double amount)
        {
            if(amount > balance)
                System.out.println("Insuffiecient funds.");
            else
                balance -= amount; //withdraws set amount from balance
        }
        public void deposite(double amount)
        {
            balance += amount;//adds amount to current balance
        }
}
