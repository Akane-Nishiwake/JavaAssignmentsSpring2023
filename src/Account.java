public class Account {
        private int id;
        private double balance;
        public Account(int _id, double _balance)
        {
            id = _id; //initializes  id
            balance = _balance;//initializes balance
        }
        public int getId()
        {
            return id;
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
